package com.ronmob.qz.model;

import java.math.BigDecimal;

public class User {
    private Integer id;

    private String userName;

    private String password;

    private String mobile;

    private String wxUserName;

    private String wxOpenId;

    private Byte isAgent;

    private Integer agentPayOrderId;

    private BigDecimal score;

    private BigDecimal balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWxUserName() {
        return wxUserName;
    }

    public void setWxUserName(String wxUserName) {
        this.wxUserName = wxUserName == null ? null : wxUserName.trim();
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    public Byte getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(Byte isAgent) {
        this.isAgent = isAgent;
    }

    public Integer getAgentPayOrderId() {
        return agentPayOrderId;
    }

    public void setAgentPayOrderId(Integer agentPayOrderId) {
        this.agentPayOrderId = agentPayOrderId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}