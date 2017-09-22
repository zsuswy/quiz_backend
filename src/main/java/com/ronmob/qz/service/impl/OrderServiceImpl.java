package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.OrderMapper;
import com.ronmob.qz.model.Order;
import com.ronmob.qz.model.OrderExample;
import com.ronmob.qz.service.OrderService;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    private OrderExample getOrderExample(SearchVo searchVo) {
        OrderExample orderExample = new OrderExample();
        if (searchVo.getParams().containsKey("id")) {
            orderExample.createCriteria().andIdEqualTo(new Integer(searchVo.getParams().get("id").toString()));
        }
        return orderExample;
    }

    @Override
    public List<Order> getOrderList(SearchVo searchVo) {
        return orderMapper.selectByExample(getOrderExample(searchVo));
    }

    @Override
    public Integer getOrderListTotalCount(SearchVo searchVo) {
        return ((Long) orderMapper.countByExample(getOrderExample(searchVo))).intValue();
    }

    @Override
    public Order createOrder(Order order) {
        orderMapper.insert(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    @Override
    public Integer deleteOrderById(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }
}