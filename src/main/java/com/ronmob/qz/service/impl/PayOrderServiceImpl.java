package com.ronmob.qz.service.impl;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.dao.PayOrderMapper;
import com.ronmob.qz.model.PayOrder;
import com.ronmob.qz.model.PayOrderExample;
import com.ronmob.qz.service.PayOrderService;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class PayOrderServiceImpl implements PayOrderService {
    @Autowired
    PayOrderMapper payOrderMapper;

    private PayOrderExample getOrderExample(SearchVo searchVo) throws Exception {
        PayOrderExample example = new PayOrderExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        if (searchVo.getParams().containsKey("id")) {
            example.createCriteria().andIdEqualTo(Util.getInteger(searchVo.getParams().get("id").toString()));
        }
        if (searchVo.getParams().containsKey("userId")) {
            example.createCriteria().andUserIdEqualTo(Util.getInteger(searchVo.getParams().get("userId").toString()));
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
    public List<PayOrder> getOrderList(SearchVo searchVo) throws Exception {
        return payOrderMapper.selectByExample(getOrderExample(searchVo));
    }

    @Override
    public PayOrder getOrder(Integer id) throws Exception {
        return payOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getOrderListTotalCount(SearchVo searchVo) throws Exception {
        return ((Long) payOrderMapper.countByExample(getOrderExample(searchVo))).intValue();
    }

    @Override
    public PayOrder createOrder(PayOrder order) {
        payOrderMapper.insert(order);
        return order;
    }

    @Override
    public PayOrder updateOrder(PayOrder order) {
        payOrderMapper.updateByPrimaryKeySelective(order);
        return order;
    }

    @Override
    public Integer deleteOrderById(Integer id) {
        return payOrderMapper.deleteByPrimaryKey(id);
    }
}