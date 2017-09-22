package com.ronmob.qz.vo;

import com.ronmob.qz.model.Order;
import com.ronmob.qz.model.common.Page;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class ListResultVo {
    private Page page;
    private List list;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
