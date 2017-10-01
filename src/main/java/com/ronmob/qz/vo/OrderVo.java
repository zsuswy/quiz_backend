package com.ronmob.qz.vo;

import com.ronmob.qz.model.PayOrder;
import java.util.Map;

/**
 * 创建时间：01/10/2017
 * 创建人：sunwuyang
 */
public class OrderVo {
    private PayOrder order;
    private Map params;

    public PayOrder getOrder() {
        return order;
    }

    public void setOrder(PayOrder order) {
        this.order = order;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}
