package com.ronmob.qz.dao;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyDimensionScoreTextListSearchVo;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;

import java.util.List;

public interface SurveyDimensionScoreTextMapper {
    // ------------------------ SurveyDimension 相关操作 ------------------------
    List<SurveyDimensionScoreText> getSurveyDimensionScoreTexts(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextListSearchVo);

    Long getSurveyDimensionScoreTextCount(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextListSearchVo);

    void insertSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText);

    void updateSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText);

    void deleteSurveyDimensionScoreText(Long id);

    // ------------------------ SurveyDimensionScoreTextService 相关操作 ------------------------
}