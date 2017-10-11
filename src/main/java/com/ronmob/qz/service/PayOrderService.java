package com.ronmob.qz.service;

import com.ronmob.qz.model.PayOrder;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface PayOrderService {
    List<PayOrder> getOrderList(SearchVo searchVo) throws Exception;

    Integer getOrderListTotalCount(SearchVo searchVo) throws Exception;

    PayOrder getOrder(Integer id) throws Exception;

    PayOrder getOrderByOutTradeNo(String out_trade_no) throws Exception;

    PayOrder createOrder(PayOrder order) throws Exception;

    PayOrder updateOrder(PayOrder order) throws Exception;

    Integer deleteOrderById(Integer id) throws Exception;

    PayOrder getNoPayOrder(Integer surveyId, Integer userId) throws Exception;

    PayOrder createOrGetPayOrder(PayOrder payOrder) throws Exception;

    Map createWxOrderForJsApi(PayOrder order, String wxOpenId, String ipAddress) throws Exception;

    Map queryWxOrder(Integer orderId) throws Exception;
}
