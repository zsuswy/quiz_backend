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
    private List<SurveyDimensionScoreText> surveyDimensionScoreTextList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<SurveyDimensionScoreText> getSurveyDimensionScoreTextList() {
        return surveyDimensionScoreTextList;
    }

    public void setSurveyDimensionScoreTextList(List<SurveyDimensionScoreText> surveyDimensionScoreTextList) {
        this.surveyDimensionScoreTextList = surveyDimensionScoreTextList;
    }
}
