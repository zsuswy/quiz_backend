package com.ronmob.qz.vo;

import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.common.Page;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class SurveyDimensionScoreTextListSearchVo {
    private Page page;
    private SurveyDimensionScoreText surveyDimensionScoreText;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public SurveyDimensionScoreText getSurveyDimensionScoreText() {
        return surveyDimensionScoreText;
    }

    public void setSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText) {
        this.surveyDimensionScoreText = surveyDimensionScoreText;
    }
}
