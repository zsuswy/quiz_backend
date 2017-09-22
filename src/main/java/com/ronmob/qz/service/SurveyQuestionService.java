package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SearchVo;
import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface SurveyQuestionService {
    List<SurveyQuestion> getSurveyQuestionList(SearchVo searchVo);

    Integer getSurveyQuestionListTotalCount(SearchVo searchVo);

    SurveyQuestion createSurveyQuestion(SurveyQuestion surveyQuestion);

    SurveyQuestion updateSurveyQuestion(SurveyQuestion surveyQuestion);
}
