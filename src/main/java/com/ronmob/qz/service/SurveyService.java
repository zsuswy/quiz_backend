package com.ronmob.qz.service;

import java.util.List;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyDimensionScoreTextListSearchVo;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;

/**
 *
 */
public interface SurveyService {

    //----------------Survey相关操作-------------------
    List<Survey> getSurveys(SurveyListSearchVo surveyVo);

    Long getSurveysCount(SurveyListSearchVo surveyVo);

    Survey insertSurvey(Survey survey);

    void updateSurvey(Survey survey);
}
