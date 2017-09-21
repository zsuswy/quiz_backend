package com.ronmob.qz.service.impl;

import java.util.List;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronmob.qz.dao.SurveyMapper;
import com.ronmob.qz.service.SurveyService;
import com.ronmob.qz.vo.SurveyListSearchVo;

/**
 *
 */
@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyMapper surveyMapper;

    private SurveyExample getSurveyExample(SurveyListSearchVo vo) {
        SurveyExample example = new SurveyExample();
        return example;
    }

    @Override
    public List<Survey> getSurveyList(SurveyListSearchVo surveyVo) {
        SurveyExample example = getSurveyExample(surveyVo);

        return surveyMapper.selectByExample(example);
    }

    @Override
    public Integer getSurveyListTotalCount(SurveyListSearchVo surveyVo) {
        SurveyExample example = getSurveyExample(surveyVo);

        return ((Long) surveyMapper.countByExample(example)).intValue();
    }

    @Override
    public Survey createSurvey(Survey survey) {
        surveyMapper.insert(survey);
        return survey;
    }

    @Override
    public Survey updateSurvey(Survey survey) {
        surveyMapper.updateByPrimaryKey(survey);
        return survey;
    }
}
