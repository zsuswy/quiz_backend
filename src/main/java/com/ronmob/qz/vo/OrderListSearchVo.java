package com.ronmob.qz.vo;

import com.ronmob.qz.model.Order;
import com.ronmob.qz.model.common.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class OrderListSearchVo {
    private Page page;
    private Map params;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}
