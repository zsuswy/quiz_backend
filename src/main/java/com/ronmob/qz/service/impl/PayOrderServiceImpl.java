package com.ronmob.qz.service.impl;

import com.github.binarywang.wxpay.bean.request.WxPayBaseRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.ronmob.qz.common.Util;
import com.ronmob.qz.common.WxHelper;
import com.ronmob.qz.dao.PayOrderMapper;
import com.ronmob.qz.model.*;
import com.ronmob.qz.service.PayOrderService;
import com.ronmob.qz.service.SurveyService;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.SearchVo;
import com.ronmob.qz.web.PayOrderController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class PayOrderServiceImpl implements PayOrderService {
    private static Log logger = LogFactory.getLog(PayOrderController.class);

    @Autowired
    PayOrderMapper payOrderMapper;

    @Autowired
    UserService userService;

    @Autowired
    SurveyService surveyService;

    @Autowired
    UserSurveyService userSurveyService;

    private PayOrderExample getOrderExample(SearchVo searchVo) throws Exception {
        PayOrderExample example = new PayOrderExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        PayOrderExample.Criteria criteria = example.createCriteria();

        if (searchVo.getParams().containsKey("id")) {
            criteria.andIdEqualTo(Util.getInteger(searchVo.getParams().get("id").toString()));
        }
        if (searchVo.getParams().containsKey("userId")) {
            criteria.andUserIdEqualTo(Util.getInteger(searchVo.getParams().get("userId").toString()));
        }
        if (searchVo.getParams().containsKey("createTime_Start")) {
            criteria.andCreateTimeGreaterThanOrEqualTo(Util.getDateFromString(searchVo.getParams().get("createTime_end").toString()));
        }
        if (searchVo.getParams().containsKey("createTime_end")) {
            criteria.andCreateTimeLessThanOrEqualTo(Util.getDateFromString(searchVo.getParams().get("createTime_end").toString()));
        }

        return example;
    }

    @Override
    public List<PayOrder> getOrderList(SearchVo searchVo) throws Exception {
        return payOrderMapper.selectByExample(getOrderExample(searchVo));
    }

    @Override
    public PayOrder getOrder(Integer id) throws Exception {
        return payOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public PayOrder getOrderByOutTradeNo(String outTradeNo) throws Exception {
        return payOrderMapper.selectByOutTradeNo(outTradeNo);
    }


    @Override
    public Integer getOrderListTotalCount(SearchVo searchVo) throws Exception {
        return ((Long) payOrderMapper.countByExample(getOrderExample(searchVo))).intValue();
    }

    @Override
    @Transactional
    public PayOrder createOrder(PayOrder order) throws Exception {
        UUID uuid = UUID.randomUUID();
        // 生成out_trade_no
        order.setOutTradeNo(uuid.toString().replace("-", ""));
        payOrderMapper.insert(order);

        // 更新用户的余额和积分
        User user = new User();
        user.setId(order.getUserId());
        user.setScore(order.getScorePayAmount());
        user.setBalance(order.getBalancePayAmount());
        userService.reduceScoreBalance(user);

        return order;
    }

    @Override
    public PayOrder updateOrder(PayOrder order) {
        payOrderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    @Override
    public Integer deleteOrderById(Integer id) {
        return payOrderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取用户的Survey未支付订单
     */
    @Override
    public PayOrder getNoPayOrder(Integer surveyId, Integer userId) throws Exception {
        SearchVo searchVo = new SearchVo();
        HashMap<String, String> params = new HashMap<>();
        params.put("surveyId", surveyId.toString());
        params.put("userId", userId.toString());
        params.put("status", "0");
        searchVo.setPage(null);

        List<PayOrder> orders = this.getOrderList(searchVo);
        if (orders != null || orders.size() == 0)
            return null;

        if (orders.size() > 1) {
            logger.warn(String.format("Survey %s 未支付订单数大于1。", surveyId.toString()));
        }

        return orders.get(0);
    }

    /**
     * 创建订单，如果相同的Survey的未支付订单存在，那么不创建新订单，返回已有的数据。
     *
     * @param userOrder PayOrder参数
     * @return PayOrder
     * @throws Exception 异常
     */
    @Override
    public PayOrder createOrGetPayOrder(PayOrder userOrder) throws Exception {
        PayOrder existOrder = getNoPayOrder(userOrder.getSurveyId(), userOrder.getUserId());
        if (existOrder != null)
            return existOrder;

        Survey survey = surveyService.getSurvey(userOrder.getSurveyId());

        // 创建订单
        userOrder.setOrderStatus(new Byte("0"));
        userOrder.setCreateTime(new Date());
        userOrder.setTotalAmount(survey.getPrice());

        return this.createOrder(userOrder);
    }

    private void calculateOrderScoreBalance(PayOrder order) throws Exception {
        User user = userService.getUser(order.getUserId());
        Survey survey = surveyService.getSurvey(order.getSurveyId());

        BigDecimal scorePay;
        BigDecimal balancePay;
        BigDecimal payAmount;

        // 没有余额和积分，那么直接微信支付，不需要跳到支付页面
        if (user.getScore().longValue() < 0.1 && user.getBalance().longValue() < 0.1) {
            order.setTotalAmount(survey.getPrice());
            order.setPayAmount(survey.getPrice());
            return;
        } else {
            // 计算 余额、积分 支付金额
            if (user.getScore().doubleValue() > 0.001) {
                scorePay = survey.getPrice().longValue() > user.getScore().longValue() ? user.getScore() : survey.getPrice();
            } else {
                scorePay = new BigDecimal(0.00);
            }

            if (user.getBalance().doubleValue() > 0.1) {
                balancePay = survey.getPrice().doubleValue() - scorePay.doubleValue() > user.getBalance().doubleValue()
                        ? user.getBalance() : survey.getPrice().subtract(scorePay);
            } else {
                balancePay = new BigDecimal(0.00);
            }

            payAmount = survey.getPrice().subtract(scorePay).subtract(balancePay);
        }

        order.setPayAmount(payAmount);
        order.setTotalAmount(survey.getPrice());
        order.setScorePayAmount(scorePay);
    }


    /**
     * 根据订单创建UserSurvey
     */
    private UserSurvey createOrGetUserSurvey(PayOrder order) throws Exception {
        SearchVo vo = new SearchVo();
        HashMap<String, Object> searchParam = new HashMap<>();
        searchParam.put("orderId", order.getId());
        searchParam.put("status", 0);
        vo.setParams(searchParam);

        List<UserSurvey> userSurveyList = userSurveyService.getUserSurveyList(vo);

        if (userSurveyList == null) { // 创建
            UserSurveyWithBLOBs userSurvey = new UserSurveyWithBLOBs();
            userSurvey.setStatus(Util.getByte("0"));
            userSurvey.setOrderId(order.getId());
            userSurvey.setpUserId(order.getFromUserId());
            userSurvey.setSurveyId(order.getSurveyId());
            userSurvey.setUserId(order.getUserId());

            return this.userSurveyService.createUserSurvey(userSurvey);
        } else if (userSurveyList.size() > 1) {
            throw new Exception("订单对应的测评数据异常。");
        } else {
            return userSurveyList.get(0);
        }
    }

    @Override
    public Map createWxOrderForJsApi(PayOrder order, String wxOpenId, String ipAddress) throws Exception {
        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
        orderRequest.setBody("订单描述");

        // 重新发起一笔支付要使用原订单号
        orderRequest.setOutTradeNo(order.getOutTradeNo());
        orderRequest.setTotalFee(WxPayBaseRequest.yuanToFee("0.01"));//元转成分
        orderRequest.setOpenid(wxOpenId);
        orderRequest.setSpbillCreateIp(ipAddress);
        orderRequest.setTradeType("JSAPI");
        // orderRequest.setTimeStart("yyyyMMddHHmmss");
        // orderRequest.setTimeExpire("yyyyMMddHHmmss");

        // 直接返回前端，给支付调用
        Map<String, String> payInfo = WxHelper.getPayService().getPayInfo(orderRequest);

        this.createOrGetUserSurvey(order);
        return payInfo;
    }

    @Override
    public Map queryWxOrder(Integer orderId) {
        return null;
    }
}