package com.ronmob.qz.model;

public class UserSurveyWithBLOBs extends UserSurvey {
    private String answer;

    private String result;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}