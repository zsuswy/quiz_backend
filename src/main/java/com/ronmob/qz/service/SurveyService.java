package com.ronmob.qz.service;

import java.util.List;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.vo.SearchVo;

/**
 *
 */
public interface SurveyService {
    List<Survey> getSurveyList(SearchVo searchVo) throws Exception;

    Integer getSurveyListTotalCount(SearchVo searchVo) throws Exception;

    Survey createSurvey(Survey survey) throws Exception;

    Survey updateSurvey(Survey survey) throws Exception;
}
