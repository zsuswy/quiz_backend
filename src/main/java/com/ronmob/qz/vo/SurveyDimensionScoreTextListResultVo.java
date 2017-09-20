package com.ronmob.qz.vo;

import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.common.Page;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class SurveyDimensionScoreTextListResultVo {
    private Page page;
    private List<SurveyDimensionScoreText> surveyDimensionScoreTexts;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<SurveyDimensionScoreText> getSurveyDimensionScoreTexts() {
        return surveyDimensionScoreTexts;
    }

    public void setSurveyDimensionScoreTexts(List<SurveyDimensionScoreText> surveyDimensionScoreTexts) {
        this.surveyDimensionScoreTexts = surveyDimensionScoreTexts;
    }
}
