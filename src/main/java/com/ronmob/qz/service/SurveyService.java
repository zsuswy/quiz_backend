package com.ronmob.qz.service;

import java.util.List;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.vo.SearchVo;

/**
 *
 */
public interface SurveyService {
    List<Survey> getSurveyList(SearchVo searchVo);

    Integer getSurveyListTotalCount(SearchVo searchVo);

    Survey createSurvey(Survey survey);

    Survey updateSurvey(Survey survey);
}
