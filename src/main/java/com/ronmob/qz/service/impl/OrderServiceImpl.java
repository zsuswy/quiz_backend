package com.ronmob.qz.service.impl;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.dao.OrderMapper;
import com.ronmob.qz.model.Order;
import com.ronmob.qz.model.OrderExample;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.OrderService;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    private OrderExample getOrderExample(SearchVo searchVo) throws Exception {
        OrderExample example = new OrderExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        if (searchVo.getParams().containsKey("id")) {
            example.createCriteria().andIdEqualTo(new Integer(searchVo.getParams().get("id").toString()));
        }
        if (searchVo.getParams().containsKey("userId")) {
            example.createCriteria().andUserIdEqualTo(new Integer(searchVo.getParams().get("userId").toString()));
        }
        if (searchVo.getParams().containsKey("createTime_Start")) {
            example.createCriteria().andCreateTimeGreaterThanOrEqualTo(Util.getDateFromString(searchVo.getParams().get("createTime_end").toString()));
        }
        if (searchVo.getParams().containsKey("createTime_end")) {
            example.createCriteria().andCreateTimeLessThanOrEqualTo(Util.getDateFromString(searchVo.getParams().get("createTime_end").toString()));
        }

        return example;
    }

    @Override
    public List<Order> getOrderList(SearchVo searchVo) throws Exception {
        return orderMapper.selectByExample(getOrderExample(searchVo));
    }

    @Override
    public Order getOrder(Integer id) throws Exception {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getOrderListTotalCount(SearchVo searchVo) throws Exception {
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