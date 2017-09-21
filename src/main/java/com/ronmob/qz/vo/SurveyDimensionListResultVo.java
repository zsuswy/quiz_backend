package com.ronmob.qz.vo;

import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.common.Page;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class SurveyDimensionListResultVo {
    private Page page;
    private List<SurveyDimension> surveyDimensionList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<SurveyDimension> getSurveyDimensionList() {
        return surveyDimensionList;
    }

    public void setSurveyDimensionList(List<SurveyDimension> surveyDimensionList) {
        this.surveyDimensionList = surveyDimensionList;
    }
}
