package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.SurveyDimensionMapper;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.service.SurveyDimensionService;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class SurveyDimensionServiceImpl implements SurveyDimensionService {
    @Autowired
    SurveyDimensionMapper surveyDimensionMapper;

    @Override
    public List<SurveyDimension> getSurveyDimensionList(SurveyDimensionListSearchVo surveyDimensionVo) {
        return surveyDimensionMapper.getSurveyDimensionList(surveyDimensionVo);
    }

    @Override
    public Integer getSurveyDimensionListTotalCount(SurveyDimensionListSearchVo surveyDimensionVo) {
        return surveyDimensionMapper.getSurveyDimesionListTotalCount(surveyDimensionVo);
    }

    @Override
    public SurveyDimension createSurveyDimension(SurveyDimension surveyDimension) {
        surveyDimensionMapper.insertSurveyDimension(surveyDimension);
        return surveyDimension;
    }

    @Override
    public SurveyDimension updateSurveyDimension(SurveyDimension surveyDimension) {
        surveyDimensionMapper.updateSurveyDimension(surveyDimension);
        return surveyDimension;
    }

    @Override
    public Integer deleteSurveyDimension(Integer id) {
        return surveyDimensionMapper.deleteSurveyDimensionById(id);
    }
}
