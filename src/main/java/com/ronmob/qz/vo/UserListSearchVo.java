package com.ronmob.qz.vo;

import com.ronmob.qz.model.User;
import com.ronmob.qz.model.common.Page;

public class UserListSearchVo {
    private Page page;
    private User user;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}