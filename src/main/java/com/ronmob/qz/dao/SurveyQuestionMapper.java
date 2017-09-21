package com.ronmob.qz.dao;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;

import java.util.List;

public interface SurveyQuestionMapper {
    SurveyQuestion getSurveyQuestionById(Integer id);

    SurveyQuestion getSurveyQuestionBySeq(Integer seq, Integer survey_id);

    List<SurveyQuestion> getSurveyQuestionList(SurveyQuestionListSearchVo surveyQuestionVo);

    Integer getSurveyQuestionListTotalCount(SurveyQuestionListSearchVo surveyQuestionVo);

    Integer insertSurveyQuestion(SurveyQuestion surveyQuestion);

    Integer updateSurveyQuestion(SurveyQuestion surveyQuestion);

    Integer deleteSurveyQuestionById(Integer id);
}