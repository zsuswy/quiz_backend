package com.ronmob.qz.model;

import java.util.Date;

public class UserSurvey {
    private Integer id;

    private Integer userId;

    private Integer pUserId;

    private Byte status;

    private Integer surveyId;

    private Integer orderId;

    private Date finishTime;

    private String className;

    private Byte isNeedSex;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getpUserId() {
        return pUserId;
    }

    public void setpUserId(Integer pUserId) {
        this.pUserId = pUserId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Byte getIsNeedSex() {
        return isNeedSex;
    }

    public void setIsNeedSex(Byte isNeedSex) {
        this.isNeedSex = isNeedSex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}