package com.ronmob.qz.service;

import com.ronmob.qz.model.Order;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface OrderService {
    List<Order> getOrderList(SearchVo searchVo);

    Integer getOrderListTotalCount(SearchVo searchVo);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    Integer deleteOrderById(Integer id);

}
