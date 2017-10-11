package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.*;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.PayOrderService;
import com.ronmob.qz.service.SurveyService;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

    @RequestMapping(value = "/pay", produces = "application/json")
    @ResponseBody
    public ResponseResult pay(HttpServletRequest req, @RequestBody PayOrder payOrder) {
        ResponseResult result = new ResponseResult();
        HashMap<String, Object> data = new HashMap<>();
        try {
            PayOrder ord = payOrderService.createOrGetPayOrder(payOrder);
            data.put("order", ord);

            if (ord.getPayAmount().doubleValue() < 0.0001) {// 不需要微信支付
                data.put("wxpPayType", "none");
            }
            // 需要部分支付，那么返回微信支付订单
            else if (ord.getPayAmount().doubleValue() > 0.001 &&
                    (ord.getBalancePayAmount().doubleValue() > 0.00001
                            || ord.getScorePayAmount().doubleValue() > 0.00001)) {
                // 重新发起一笔支付要使用原订单号,逻辑已处理
                Map payInfo = this.payOrderService.createWxOrderForJsApi(ord, req.getHeader("Accept-Wx"), Util.getIpAddress(req));
                data.put("payInfo", payInfo);
                data.put("wxpPayType", "partial");
            } else {
                data.put("wxpPayType", "all");
            }

            result.setData(data);
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
            ex.printStackTrace();
            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/confirm", produces = "application/json")
    @ResponseBody
    public ResponseResult confirmOrder(Integer orderId) {
        ResponseResult result = new ResponseResult();
        try {
            result.setData(this.payOrderService.confirmOrder(orderId));
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            ex.printStackTrace();
        }

        return result;
    }

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