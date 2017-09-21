package com.ronmob.qz.service;

import com.ronmob.qz.model.Order;
import com.ronmob.qz.vo.OrderListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface OrderService {
    List<Order> getOrderList(OrderListSearchVo searchVo);

    Integer getOrderListTotalCount(OrderListSearchVo searchVo);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    Integer deleteOrderById(Integer id);

}
