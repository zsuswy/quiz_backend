package com.ronmob.qz.vo;

import com.ronmob.qz.model.Order;
import com.ronmob.qz.model.common.Page;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class OrderListSearchVo {
    private Page page;
    private Order order;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
