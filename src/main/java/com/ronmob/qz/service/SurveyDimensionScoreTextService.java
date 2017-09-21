package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.vo.SurveyDimensionScoreTextListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface SurveyDimensionScoreTextService {
    //----------------SurveyDimensionScoreText相关操作-------------------
    List<SurveyDimensionScoreText> getSurveyDimensionScoreTextList(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextVo);

    Integer getSurveyDimensionsScoreTextListTotalCount(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextVo);

    SurveyDimensionScoreText createSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText);

    SurveyDimensionScoreText updateSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText);
}
