package com.ronmob.qz.dao;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;

import java.util.List;

public interface SurveyQuestionMapper {
    // ------------------------ SurveyQuestion 相关操作 ------------------------
    SurveyQuestion getSurveyQuestionById(Integer id);

    SurveyQuestion getSurveyQuestionBySeq(int seq, Integer survey_id);

    List<SurveyQuestion> getSurveyQuestions(SurveyQuestionListSearchVo surveyQuestionVo);

    Integer getSurveyQuestionsCount(SurveyQuestionListSearchVo surveyQuestionVo);

    void insertSurveyQuestion(SurveyQuestion surveyQuestion);

    void updateSurveyQuestion(SurveyQuestion surveyQuestion);
}