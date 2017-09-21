package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyDimensionScoreTextListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface SurveyQuestionService {
    //----------------SurveyQuestion相关操作-------------------
    List<SurveyQuestion> getSurveyQuestionList(SurveyQuestionListSearchVo surveyQuestionListSearchVo);

    Integer getSurveyQuestionListTotalCount(SurveyQuestionListSearchVo surveyQuestionListSearchVo);

    SurveyQuestion createSurveyQuestion(SurveyQuestion surveyQuestion);

    SurveyQuestion updateSurveyQuestion(SurveyQuestion surveyQuestion);
}
