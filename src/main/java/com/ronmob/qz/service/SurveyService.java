package com.ronmob.qz.service;

import java.util.List;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.vo.SurveyListSearchVo;

/**
 *
 */
public interface SurveyService {
    List<Survey> getSurveyList(SurveyListSearchVo surveyVo);

    Integer getSurveyListTotalCount(SurveyListSearchVo surveyVo);

    Survey createSurvey(Survey survey);

    Survey updateSurvey(Survey survey);
}
