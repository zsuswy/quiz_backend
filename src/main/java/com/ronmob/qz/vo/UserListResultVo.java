package com.ronmob.qz.vo;

import com.ronmob.qz.model.User;
import com.ronmob.qz.model.common.Page;

import java.util.List;

public class UserListResultVo {
    private Page page;
    private List<User> userList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}