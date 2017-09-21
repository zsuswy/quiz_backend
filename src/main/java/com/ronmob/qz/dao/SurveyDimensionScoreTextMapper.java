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

    Integer getSurveyDimensionScoreTextTotalCount(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextListSearchVo);

    Integer insertSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText);

    Integer updateSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText);

    Integer deleteSurveyDimensionScoreText(Integer id);

    // ------------------------ SurveyDimensionScoreTextService 相关操作 ------------------------
}