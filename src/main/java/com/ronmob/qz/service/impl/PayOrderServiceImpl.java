package com.ronmob.qz.service.impl;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.common.WxHelper;
import com.ronmob.qz.dao.PayOrderMapper;
import com.ronmob.qz.model.*;
import com.ronmob.qz.service.PayOrderService;
import com.ronmob.qz.service.SurveyService;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.OrderVo;
import com.ronmob.qz.vo.SearchVo;
import com.ronmob.qz.web.PayOrderController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Integer getOrderListTotalCount(SearchVo searchVo) throws Exception {
        return ((Long) payOrderMapper.countByExample(getOrderExample(searchVo))).intValue();
    }

    @Override
    public PayOrder createOrder(PayOrder order) {
        payOrderMapper.insert(order);
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
     * */
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
     * @param orderVo
     * @return
     * @throws Exception
     */
    public PayOrder createOrGetPayOrder(OrderVo orderVo) throws Exception {
        PayOrder ord = orderVo.getOrder();

        PayOrder noPayOrder = getNoPayOrder(ord.getSurveyId(), ord.getUserId());
        if (noPayOrder == null) {
            // 创建订单
            ord.setOrderStatus(new Byte("0"));
            ord.setCreateTime(new Date());
            noPayOrder = this.createOrder(ord);
        }

        return noPayOrder;
    }

    // 确认订单
    public UserSurvey confirmSurveyOrder(Integer orderId) throws Exception {
        PayOrder order = this.getOrder(orderId);
        order.setOrderStatus(new Byte("1"));
        order.setFinishTime(new Date());

        // 根据订单，更新积分、账户余额等信息
        if (order.getBalancePayAmount() != null || order.getScorePayAmount() != null) {
            User scoreBalancUpdateInfo = new User();
            scoreBalancUpdateInfo.setId(order.getUserId());
            if (order.getBalancePayAmount() != null) {
                scoreBalancUpdateInfo.setBalance(order.getBalancePayAmount());
            }
            if (order.getScorePayAmount() != null) {
                scoreBalancUpdateInfo.setScore(order.getScorePayAmount());
            }
            if (userService.reduceScoreBalance(scoreBalancUpdateInfo) != 1) {
                throw new Exception("账户余额或积分不足");
            }
        }
        // 更新订单状态
        this.updateOrder(order);

        SearchVo vo = new SearchVo();
        HashMap<String, Object> searchParam = new HashMap<>();
        searchParam.put("orderId", order.getId());
        searchParam.put("status", 0);

        vo.setParams(searchParam);

        List<UserSurvey> userSurveyList = userSurveyService.getUserSurveyList(vo);
        if (userSurveyList.size() != 1) {
            throw new Exception("找不到对应的订单");
        }

        UserSurvey userSurvey = userSurveyList.get(0);
        userSurvey.setStatus(new Byte("1"));

        userSurveyService.updateUserSurvey(userSurvey);
        Survey survey = surveyService.getSurvey(userSurvey.getSurveyId());
        WxHelper.sendBuySuccess(order.getWxOpenId(),
                survey.getTitle(),
                "http://quiz.ronmob.com/qz/mobile/#/survey-detail-initial/" + userSurvey.getSurveyId().toString());

        return userSurvey;
    }
}