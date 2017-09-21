package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.OrderMapper;
import com.ronmob.qz.model.Order;
import com.ronmob.qz.service.OrderService;
import com.ronmob.qz.vo.OrderListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> getOrderList(OrderListSearchVo searchVo) {
        return orderMapper.getOrderList(searchVo);
    }

    @Override
    public Integer getOrderListTotalCount(OrderListSearchVo searchVo) {
        return orderMapper.getOrderListTotalCount(searchVo);
    }

    @Override
    public Order createOrder(Order order) {
        orderMapper.insertOrder(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        orderMapper.updateOrder(order);
        return order;
    }

    @Override
    public Integer deleteOrderById(Integer id) {
        return orderMapper.deleteOrderById(id);
    }


}
