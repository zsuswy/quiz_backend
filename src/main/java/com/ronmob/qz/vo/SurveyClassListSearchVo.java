package com.ronmob.qz.vo;

import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.model.common.Page;

public class SurveyClassListSearchVo {
    private Page page;
    private SurveyClass surveyClass;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public SurveyClass getSurveyClass() {
        return surveyClass;
    }

    public void setSurveyClass(SurveyClass surveyClass) {
        this.surveyClass = surveyClass;
    }
}
