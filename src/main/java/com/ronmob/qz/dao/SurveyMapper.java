package com.ronmob.qz.dao;

import java.util.List;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;

public interface SurveyMapper {
    // ------------------------ Survey 相关操作 ------------------------
    Survey getSurveyById(int id);

    List<Survey> getSurveys(SurveyListSearchVo surveyVo);

    Long getSurveysCount(SurveyListSearchVo surveyVo);

    Survey insertSurvey(Survey survey);

    Survey updateSurvey(Survey survey);
}