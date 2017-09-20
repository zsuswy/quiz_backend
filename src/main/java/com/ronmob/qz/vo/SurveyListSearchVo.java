package com.ronmob.qz.vo;

import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.Survey;

public class SurveyListSearchVo {
    Page page;
    Survey survey;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

}