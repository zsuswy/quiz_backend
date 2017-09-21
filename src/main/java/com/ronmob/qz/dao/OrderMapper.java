package com.ronmob.qz.dao;

import com.ronmob.qz.model.Order;
import com.ronmob.qz.vo.OrderListSearchVo;

import java.util.List;

public interface OrderMapper {
    List<Order> getOrderList(OrderListSearchVo orderListSearchVo);

    Integer getOrderListTotalCount(OrderListSearchVo orderListSearchVo);

    Integer insertOrder(Order order);

    Integer updateOrder(Order order);

    Integer deleteById(Integer id);

}
