package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.PayOrder;
import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.UserSurveyWithBLOBs;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.PayOrderService;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.OrderVo;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class PayOrderController {

    private static Log logger = LogFactory.getLog(PayOrderController.class);

    @Autowired
    private PayOrderService payOrderService;

    @Autowired
    private UserSurveyService userSurveyService;

    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getOrderList(HttpSession httpSession, @RequestBody SearchVo searchVo) {
        ResponseResult result = new ResponseResult();
        ListResultData listResultData = new ListResultData();

        try {
            Page page = Util.getPageFromSearchVo(searchVo);
            if (page != null) {
                page.setTotalCount(payOrderService.getOrderListTotalCount(searchVo));
                listResultData.setPage(page);
            }

            listResultData.setList(payOrderService.getOrderList(searchVo));
            result.setSuccess(true);
            result.setData(listResultData);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }
        return result;
    }

    @RequestMapping(value = "/get", produces = "application/json")
    @ResponseBody
    public ResponseResult getOrder(Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            result.setSuccess(true);
            result.setData(this.payOrderService.getOrder(id));
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public ResponseResult createOrder(HttpSession httpSession, @RequestBody OrderVo orderVo) {
        ResponseResult result = new ResponseResult();
        try {
            UserSurvey userSurvey = this.createUserSurveyOrder(orderVo);
            HashMap<String, Object> data = new HashMap<>();
            data.put("orderId", orderVo.getOrder().getId());
            data.put("userSurveyId", userSurvey.getId());

            result.setData(data);
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/confirmOrder", produces = "application/json")
    @ResponseBody
    public ResponseResult confirmOrder(HttpSession httpSession, @RequestBody Map params) {
        ResponseResult result = new ResponseResult();
        try {
            System.out.println(params.get("orderId"));
            result.setData(this.confirmSurveyOrder(Util.getInteger(params.get("orderId").toString())));
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
            ex.printStackTrace();
            logger.error(ex);
        }

        return result;
    }

    @Transactional
    public UserSurvey createUserSurveyOrder(OrderVo orderVo) throws Exception {
        Map params = orderVo.getParams();
        PayOrder ord = orderVo.getOrder();

        // 创建订单
        ord.setOrderStatus(new Byte("0"));
        ord.setCreateTime(new Date());
        this.payOrderService.createOrder(ord);

        // 创建userSurvey
        UserSurveyWithBLOBs userSurvey = new UserSurveyWithBLOBs();
        userSurvey.setUserId(1); // TODO: hardcoded
        userSurvey.setSurveyId(ord.getBusinessId());
        userSurvey.setOrderId(ord.getId());
        userSurvey.setStatus(new Byte("0"));
        if (params != null && params.containsKey("from_user_id")) {     // 设置分销用户
            userSurvey.setpUserId(new Integer(params.get("from_user_id").toString()));
        }
        this.userSurveyService.createUserSurvey(userSurvey);            // 创建 用户测评关联

        // 更新订单关联业务主键id
        ord.setBusinessId(userSurvey.getId());
        this.payOrderService.updateOrder(ord);

        return userSurvey;
    }

    @Transactional
    public UserSurvey confirmSurveyOrder(Integer orderId) throws Exception {
        PayOrder order = payOrderService.getOrder(orderId);
        order.setOrderStatus(new Byte("1"));
        order.setFinishTime(new Date());

        // TODO: 更新账户余额等

        // 更新订单状态
        payOrderService.updateOrder(order);

        SearchVo vo = new SearchVo();
        HashMap<String, Object> searchParam = new HashMap<>();
        searchParam.put("orderId", order.getBusinessId());
        searchParam.put("status", 0);

        vo.setParams(searchParam);

        List<UserSurvey> userSurveyList = userSurveyService.getUserSurveyList(vo);
        if (userSurveyList.size() != 1) {
            throw new Exception("");
        }

        UserSurvey userSurvey = userSurveyList.get(0);
        userSurvey.setStatus(new Byte("1"));

        userSurveyService.updateUserSurvey(userSurvey);

        return userSurvey;
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseResult updateOrder(HttpSession httpSession, @RequestBody PayOrder order) {
        ResponseResult result = new ResponseResult();
        try {
            this.payOrderService.updateOrder(order);
            result.setSuccess(true);
            result.setData(order);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/delete", produces = "application/json")
    @ResponseBody
    public ResponseResult deleteOrder(HttpSession httpSession, Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            if (id == null) {
                throw new Exception("id参数为空");
            }

            payOrderService.deleteOrderById(id);

            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }
}