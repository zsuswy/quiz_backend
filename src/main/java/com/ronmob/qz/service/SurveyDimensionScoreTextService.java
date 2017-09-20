package com.ronmob.qz.service;

import com.ronmob.qz.vo.SurveyDimensionScoreTextListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface SurveyDimensionScoreTextService {
    //----------------SurveyDimensionScoreText相关操作-------------------
    List<com.ronmob.qz.model.SurveyDimensionScoreText> getSurveyDimensionScoreTexts(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextVo);

    Long getSurveyDimensionsScoreTextCount(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextVo);

    com.ronmob.qz.model.SurveyDimensionScoreText insertSurveyDimensionScoreText(com.ronmob.qz.model.SurveyDimensionScoreText surveyDimensionScoreText);

    void updateSurveyDimensionScoreText(com.ronmob.qz.model.SurveyDimensionScoreText surveyDimensionScoreText);
}
