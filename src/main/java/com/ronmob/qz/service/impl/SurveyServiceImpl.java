package com.ronmob.qz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronmob.qz.dao.SurveyMapper;
import com.ronmob.qz.model.Survey;
import com.ronmob.qz.service.SurveyService;
import com.ronmob.qz.vo.SurveyListSearchVo;

/**
 *
 */
@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyMapper surveyMapper;

    @Override
    public List<Survey> getSurveyList(SurveyListSearchVo surveyVo) {
        return surveyMapper.getSurveyList(surveyVo);
    }

    @Override
    public Integer getSurveyListTotalCount(SurveyListSearchVo surveyVo) {
        return surveyMapper.getSurveyListTotalCount(surveyVo);
    }

    @Override
    public Survey createSurvey(Survey survey) {
        surveyMapper.insertSurvey(survey);
        return survey;
    }

    @Override
    public Survey updateSurvey(Survey survey) {
        surveyMapper.updateSurvey(survey);
        return survey;
    }
}
