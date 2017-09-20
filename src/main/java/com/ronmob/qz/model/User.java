package com.ronmob.qz.model;

import java.math.BigDecimal;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class User {
    private Integer id;
    private String user_name;
    private String password;
    private String mobile;
    private String wx_user_name;
    private String wx_open_id;
    private Integer is_agent;
    private Integer agent_pay_order_id;
    private Integer score;
    private BigDecimal balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWx_user_name() {
        return wx_user_name;
    }

    public void setWx_user_name(String wx_user_name) {
        this.wx_user_name = wx_user_name;
    }

    public String getWx_open_id() {
        return wx_open_id;
    }

    public void setWx_open_id(String wx_open_id) {
        this.wx_open_id = wx_open_id;
    }

    public Integer getIs_agent() {
        return is_agent;
    }

    public void setIs_agent(Integer is_agent) {
        this.is_agent = is_agent;
    }

    public Integer getAgent_pay_order_id() {
        return agent_pay_order_id;
    }

    public void setAgent_pay_order_id(Integer agent_pay_order_id) {
        this.agent_pay_order_id = agent_pay_order_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
