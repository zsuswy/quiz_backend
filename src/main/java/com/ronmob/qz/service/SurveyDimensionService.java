package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Repository
public interface SurveyDimensionService {
    List<SurveyDimension> getSurveyDimensionList(SurveyDimensionListSearchVo surveyDimensionVo);

    Integer getSurveyDimensionListTotalCount(SurveyDimensionListSearchVo surveyDimensionVo);

    SurveyDimension createSurveyDimension(SurveyDimension surveyDimension);

    SurveyDimension updateSurveyDimension(SurveyDimension surveyDimension);

    Integer deleteSurveyDimension(Integer id);

}

