package com.ronmob.qz.service;

import com.ronmob.qz.model.Order;
import com.ronmob.qz.vo.SearchVo;

import java.text.ParseException;
import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface OrderService {
    List<Order> getOrderList(SearchVo searchVo) throws Exception;

    Integer getOrderListTotalCount(SearchVo searchVo) throws Exception;

    Order createOrder(Order order) throws Exception;

    Order updateOrder(Order order) throws Exception;

    Integer deleteOrderById(Integer id) throws Exception;

}
