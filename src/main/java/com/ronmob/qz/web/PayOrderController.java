package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.common.WxHelper;
import com.ronmob.qz.model.*;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.PayOrderService;
import com.ronmob.qz.service.SurveyService;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.OrderVo;
import com.ronmob.qz.vo.SearchVo;
import com.sun.corba.se.spi.activation.ServerAlreadyRegisteredHelper;
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
    private SurveyService surveyService;

    @Autowired
    private UserService userService;


    @Autowired
    private UserSurveyService userSurveyService;

    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getOrderList(@RequestBody SearchVo searchVo) {
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
    public ResponseResult createOrder(@RequestBody OrderVo orderVo) {
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
    public ResponseResult confirmOrder(@RequestBody Map params) {
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
    public UserSurvey createUserSurvey(PayOrder order) throws Exception {
        // 创建userSurvey
        UserSurveyWithBLOBs userSurvey = new UserSurveyWithBLOBs();
        userSurvey.setUserId(order.getUserId());
        userSurvey.setSurveyId(order.getSurveyId());
        userSurvey.setOrderId(order.getId());
        userSurvey.setStatus(new Byte("0"));
        return this.userSurveyService.createUserSurvey(userSurvey);
    }



    @Transactional


    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseResult updateOrder(@RequestBody PayOrder order) {
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
    public ResponseResult deleteOrder(Integer id) {
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