package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface SurveyQuestionService {
    List<SurveyQuestion> getSurveyQuestionList(SearchVo searchVo) throws Exception;

    Integer getSurveyQuestionListTotalCount(SearchVo searchVo) throws Exception;

    SurveyQuestion createSurveyQuestion(SurveyQuestion surveyQuestion) throws Exception;

    SurveyQuestion updateSurveyQuestion(SurveyQuestion surveyQuestion) throws Exception;

    Integer deleteSurveyQuestionById(Integer id) throws Exception;

}
