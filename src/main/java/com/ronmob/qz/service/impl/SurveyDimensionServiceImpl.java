package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.SurveyDimensionMapper;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyDimensionExample;
import com.ronmob.qz.service.SurveyDimensionService;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class SurveyDimensionServiceImpl implements SurveyDimensionService {
    @Autowired
    SurveyDimensionMapper surveyDimensionMapper;


    private SurveyDimensionExample getSurveyDimensionExample(SurveyDimensionListSearchVo vo) {
        SurveyDimensionExample example = new SurveyDimensionExample();
        return example;
    }

    @Override
    public List<SurveyDimension> getSurveyDimensionList(SurveyDimensionListSearchVo surveyDimensionVo) {
        SurveyDimensionExample example = getSurveyDimensionExample(surveyDimensionVo);

        return surveyDimensionMapper.selectByExample(example);
    }

    @Override
    public Integer getSurveyDimensionListTotalCount(SurveyDimensionListSearchVo surveyDimensionVo) {
        SurveyDimensionExample example = getSurveyDimensionExample(surveyDimensionVo);

        return ((Long) surveyDimensionMapper.countByExample(example)).intValue();
    }

    @Override
    public SurveyDimension createSurveyDimension(SurveyDimension surveyDimension) {
        surveyDimensionMapper.insert(surveyDimension);
        return surveyDimension;
    }

    @Override
    public SurveyDimension updateSurveyDimension(SurveyDimension surveyDimension) {
        surveyDimensionMapper.updateByPrimaryKey(surveyDimension);
        return surveyDimension;
    }

    @Override
    public Integer deleteSurveyDimension(Integer id) {
        return surveyDimensionMapper.deleteByPrimaryKey(id);
    }
}
