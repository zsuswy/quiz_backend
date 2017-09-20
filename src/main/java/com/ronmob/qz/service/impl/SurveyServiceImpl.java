package com.ronmob.qz.service.impl;

import java.util.List;

import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyDimensionScoreTextListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronmob.qz.dao.SurveyMapper;
import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.service.SurveyService;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;

/**
 *
 */
@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyMapper surveyMapper;

    @Override
    public List<Survey> getSurveys(SurveyListSearchVo surveyVo) {
        return surveyMapper.getSurveys(surveyVo);
    }

    @Override
    public Long getSurveysCount(SurveyListSearchVo surveyVo) {
        return surveyMapper.getSurveysCount(surveyVo);
    }

    @Override
    public Survey insertSurvey(Survey survey) {
        surveyMapper.insertSurvey(survey);
        return survey;
    }

    @Override
    public void updateSurvey(Survey survey) {
        surveyMapper.updateSurvey(survey);
    }
}
