package com.ronmob.qz.service;

import com.ronmob.qz.model.PayOrder;
import com.ronmob.qz.vo.SearchVo;

import java.text.ParseException;
import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface PayOrderService {
    List<PayOrder> getOrderList(SearchVo searchVo) throws Exception;

    Integer getOrderListTotalCount(SearchVo searchVo) throws Exception;

    PayOrder getOrder(Integer id) throws Exception;

    PayOrder createOrder(PayOrder order) throws Exception;

    PayOrder updateOrder(PayOrder order) throws Exception;

    Integer deleteOrderById(Integer id) throws Exception;
}
