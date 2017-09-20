package com.ronmob.qz.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private Long id;
    private String wx_order_no;
    private String out_trade_no;
    private String wx_open_id;
    private BigDecimal pay_amount;
    private Long pay_score;
    private Integer order_status;
    private Timestamp create_time;
    private Timestamp finish_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWx_order_no() {
        return wx_order_no;
    }

    public void setWx_order_no(String wx_order_no) {
        this.wx_order_no = wx_order_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getWx_open_id() {
        return wx_open_id;
    }

    public void setWx_open_id(String wx_open_id) {
        this.wx_open_id = wx_open_id;
    }

    public BigDecimal getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(BigDecimal pay_amount) {
        this.pay_amount = pay_amount;
    }

    public Long getPay_score() {
        return pay_score;
    }

    public void setPay_score(Long pay_score) {
        this.pay_score = pay_score;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Timestamp finish_time) {
        this.finish_time = finish_time;
    }
}