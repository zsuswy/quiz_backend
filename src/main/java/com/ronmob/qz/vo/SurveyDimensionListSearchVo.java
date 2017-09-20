package com.ronmob.qz.vo;

import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.common.Page;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class SurveyDimensionListSearchVo {
    private Page page;
    private SurveyDimension surveyDimension;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public SurveyDimension getSurveyDimension() {
        return surveyDimension;
    }

    public void setSurveyDimension(SurveyDimension surveyDimension) {
        this.surveyDimension = surveyDimension;
    }
}
