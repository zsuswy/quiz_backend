package com.ronmob.qz.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class UserScoreLog {
    private Integer id;
    private Integer user_id;
    private Integer score;
    private BigDecimal amount;
    private Integer score_type;
    private Timestamp score_time;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore_type() {
        return score_type;
    }

    public void setScore_type(Integer score_type) {
        this.score_type = score_type;
    }

    public Timestamp getScore_time() {
        return score_time;
    }

    public void setScore_time(Timestamp score_time) {
        this.score_time = score_time;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
