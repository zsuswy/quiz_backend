package com.ronmob.qz.dao;

import com.ronmob.qz.model.Order;

public interface OrderMapper {
    Order selectById(int id);
    void InsertOrder(Order order);
    Order UpdateOrder(Order order);
}
