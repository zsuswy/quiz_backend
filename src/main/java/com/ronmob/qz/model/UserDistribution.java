package com.ronmob.qz.model;

import java.util.Date;

public class UserDistribution {
    private Integer id;

    private Integer fromUserId;

    private Date finishTime;

    private Integer surveyId;

    private Integer userSurveyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Integer getUserSurveyId() {
        return userSurveyId;
    }

    public void setUserSurveyId(Integer userSurveyId) {
        this.userSurveyId = userSurveyId;
    }
}