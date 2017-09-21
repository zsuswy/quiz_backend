package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.SurveyDimensionScoreTextMapper;
import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.service.SurveyDimensionScoreTextService;
import com.ronmob.qz.vo.SurveyDimensionScoreTextListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class SurveyDimensionScoreTextServiceImpl implements SurveyDimensionScoreTextService {
    @Autowired
    SurveyDimensionScoreTextMapper surveyDimensionScoreTextMapper;

    @Override
    public List<SurveyDimensionScoreText> getSurveyDimensionScoreTextList(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextVo) {
        return surveyDimensionScoreTextMapper.getSurveyDimensionScoreTextList(surveyDimensionScoreTextVo);
    }

    @Override
    public Integer getSurveyDimensionsScoreTextListTotalCount(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextVo) {
        return surveyDimensionScoreTextMapper.getSurveyDimensionScoreTextListTotalCount(surveyDimensionScoreTextVo);
    }

    @Override
    public SurveyDimensionScoreText createSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText) {
        surveyDimensionScoreTextMapper.insertSurveyDimensionScoreText(surveyDimensionScoreText);
        return surveyDimensionScoreText;
    }

    @Override
    public SurveyDimensionScoreText updateSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText) {
        surveyDimensionScoreTextMapper.updateSurveyDimensionScoreText(surveyDimensionScoreText);
        return surveyDimensionScoreText;
    }

    @Override
    public Integer deleteSurveyDimensionScoreTextById(Integer id) {
        return surveyDimensionScoreTextMapper.deleteSurveyDimensionScoreTextById(id);
    }
}
