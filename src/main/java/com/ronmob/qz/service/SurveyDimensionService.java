package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyDimensionScoreTextListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface SurveyDimensionService {
    //----------------SurveyDimension相关操作-------------------
    List<SurveyDimension> getSurveyDimensions(SurveyDimensionListSearchVo surveyDimensionVo);

    Long getSurveyDimensionsCount(SurveyDimensionListSearchVo surveyDimensionVo);

    SurveyQuestion insertSurveyDimension(SurveyDimension surveyDimension);

    void updateSurveyDimension(SurveyDimension surveyDimension);
}

