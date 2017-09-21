package com.ronmob.qz.dao;

import java.util.List;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;

public interface SurveyMapper {
    List<Survey> getSurveyList(SurveyListSearchVo surveyVo);

    Integer getSurveyListTotalCount(SurveyListSearchVo surveyVo);

    Integer insertSurvey(Survey survey);

    Integer updateSurvey(Survey survey);

    Integer deleteSurveyById(Integer id);
}