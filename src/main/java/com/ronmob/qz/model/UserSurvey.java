package com.ronmob.qz.model;

import java.sql.Timestamp;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class UserSurvey {
    private Integer id;
    private Integer user_id;
    private Integer p_user_id;
    private Integer status;
    private Integer survey_id;
    private Integer order_id;
    private Timestamp finish_time;
    private String answer;
    private String result;
    private String class_name;
    private Integer is_need_sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getP_user_id() {
        return p_user_id;
    }

    public void setP_user_id(Integer p_user_id) {
        this.p_user_id = p_user_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Integer survey_id) {
        this.survey_id = survey_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Timestamp getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Timestamp finish_time) {
        this.finish_time = finish_time;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getIs_need_sex() {
        return is_need_sex;
    }

    public void setIs_need_sex(Integer is_need_sex) {
        this.is_need_sex = is_need_sex;
    }
}
