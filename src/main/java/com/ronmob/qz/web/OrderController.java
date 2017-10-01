package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.Order;
import com.ronmob.qz.model.UserSurveyWithBLOBs;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.OrderService;
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
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    private static Log logger = LogFactory.getLog(OrderController.class);

    @Autowired
    private OrderService orderService;

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
                page.setTotalCount(orderService.getOrderListTotalCount(searchVo));
                listResultData.setPage(page);
            }

            listResultData.setList(orderService.getOrderList(searchVo));
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
            result.setData(this.orderService.getOrder(id));
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
            this.createUserSurveyOrder(orderVo);

            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @Transactional
    public void createUserSurveyOrder(OrderVo orderVo) throws Exception {
        Map params = orderVo.getParams();
        Order ord = orderVo.getOrder();

        // 创建订单
        this.orderService.createOrder(ord);
        UserSurveyWithBLOBs userSurvey = new UserSurveyWithBLOBs();
        userSurvey.setUserId(3); // TODO: hardcoded
        userSurvey.setSurveyId(ord.getBusinessId());
        userSurvey.setOrderId(ord.getId());

        // 设置分销用户
        if (params != null && params.containsKey("from_user_id")) {
            userSurvey.setpUserId(new Integer(params.get("from_user_id").toString()));
        }

        // 创建 用户测评关联
        this.userSurveyService.createUserSurvey(userSurvey);
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseResult updateOrder(HttpSession httpSession, @RequestBody Order order) {
        ResponseResult result = new ResponseResult();
        try {
            this.orderService.updateOrder(order);
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

            orderService.deleteOrderById(id);

            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }
}