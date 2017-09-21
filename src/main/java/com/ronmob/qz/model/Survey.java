package com.ronmob.qz.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Survey {
    private Integer id;
    private String title;
    private String description;
    private Integer create_by;
    private Timestamp create_time;
    private Integer class_id;
    private Integer status;
    private Integer question_cnt;
    private Integer estimate_minutes;
    private BigDecimal price;
    private BigDecimal org_price;
    private String image;
    private Integer is_need_sex;
    private Integer tested_cnt;
    private String result_template;
    private Integer is_hot;
    private Integer is_new;
    private Integer is_super;
    private String result_template_param;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Integer create_by) {
        this.create_by = create_by;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQuestion_cnt() {
        return question_cnt;
    }

    public void setQuestion_cnt(Integer question_cnt) {
        this.question_cnt = question_cnt;
    }

    public Integer getEstimate_minutes() {
        return estimate_minutes;
    }

    public void setEstimate_minutes(Integer estimate_minutes) {
        this.estimate_minutes = estimate_minutes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOrg_price() {
        return org_price;
    }

    public void setOrg_price(BigDecimal org_price) {
        this.org_price = org_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIs_need_sex() {
        return is_need_sex;
    }

    public void setIs_need_sex(Integer is_need_sex) {
        this.is_need_sex = is_need_sex;
    }

    public Integer getTested_cnt() {
        return tested_cnt;
    }

    public void setTested_cnt(Integer tested_cnt) {
        this.tested_cnt = tested_cnt;
    }

    public String getResult_template() {
        return result_template;
    }

    public void setResult_template(String result_template) {
        this.result_template = result_template;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Integer getIs_new() {
        return is_new;
    }

    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    public Integer getIs_super() {
        return is_super;
    }

    public void setIs_super(Integer is_super) {
        this.is_super = is_super;
    }

    public String getResult_template_param() {
        return result_template_param;
    }

    public void setResult_template_param(String result_template_param) {
        this.result_template_param = result_template_param;
    }
}
