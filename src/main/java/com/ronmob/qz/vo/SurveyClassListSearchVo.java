package com.ronmob.qz.vo;

import com.ronmob.qz.model.common.Page;

import java.util.Map;

public class SurveyClassListSearchVo {
    private Page page;
    private Map param;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Map getParam() {
        return param;
    }

    public void setParam(Map param) {
        this.param = param;
    }
}
