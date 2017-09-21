package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.SurveyDimensionScoreTextMapper;
import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.SurveyDimensionScoreTextExample;
import com.ronmob.qz.service.SurveyDimensionScoreTextService;
import com.ronmob.qz.vo.SurveyDimensionScoreTextListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class SurveyDimensionScoreTextServiceImpl implements SurveyDimensionScoreTextService {
    @Autowired
    SurveyDimensionScoreTextMapper surveyDimensionScoreTextMapper;

    private SurveyDimensionScoreTextExample getSurveyDimensionScoreTextExample(SurveyDimensionScoreTextListSearchVo vo) {
        SurveyDimensionScoreTextExample example = new SurveyDimensionScoreTextExample();
        return example;
    }

    @Override
    public List<SurveyDimensionScoreText> getSurveyDimensionScoreTextList(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextVo) {
        SurveyDimensionScoreTextExample example = getSurveyDimensionScoreTextExample(surveyDimensionScoreTextVo);

        return surveyDimensionScoreTextMapper.selectByExample(example);
    }

    @Override
    public Integer getSurveyDimensionsScoreTextListTotalCount(SurveyDimensionScoreTextListSearchVo surveyDimensionScoreTextVo) {
        SurveyDimensionScoreTextExample example = getSurveyDimensionScoreTextExample(surveyDimensionScoreTextVo);

        return ((Long) surveyDimensionScoreTextMapper.countByExample(example)).intValue();
    }

    @Override
    public SurveyDimensionScoreText createSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText) {
        surveyDimensionScoreTextMapper.insert(surveyDimensionScoreText);
        return surveyDimensionScoreText;
    }

    @Override
    public SurveyDimensionScoreText updateSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText) {
        surveyDimensionScoreTextMapper.insert(surveyDimensionScoreText);
        return surveyDimensionScoreText;
    }

    @Override
    public Integer deleteSurveyDimensionScoreTextById(Integer id) {
        return surveyDimensionScoreTextMapper.deleteByPrimaryKey(id);
    }
}
