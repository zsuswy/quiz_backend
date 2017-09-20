package com.ronmob.qz.service;

import com.ronmob.qz.model.Order;
import com.ronmob.qz.vo.OrderListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface OrderService {
    Order createOrder(Order order);

    Order updateOrder(Order order);

    List<Order> getOrders(OrderListSearchVo searchVo);
}
