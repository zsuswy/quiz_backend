package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.Order;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.OrderService;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {

    private static Log logger = LogFactory.getLog(OrderController.class);

    @Autowired
    private OrderService orderService;


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

    @RequestMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public ResponseResult insertOrder(HttpSession httpSession, @RequestBody Order order) {
        ResponseResult result = new ResponseResult();
        try {
            this.orderService.createOrder(order);
            result.setSuccess(true);
            result.setData(order);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
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