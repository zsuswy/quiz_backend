package com.ronmob.qz.vo;

import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.model.common.Page;

import java.util.List;

public class SurveyClassListResultVo {
    private Page page;
    private List<SurveyClass> surveyClassList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<SurveyClass> getSurveyClassList() {
        return surveyClassList;
    }

    public void setSurveyClassList(List<SurveyClass> surveyClassList) {
        this.surveyClassList = surveyClassList;
    }
}
