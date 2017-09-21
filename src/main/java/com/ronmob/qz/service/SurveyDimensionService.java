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
    List<SurveyDimension> getSurveyDimensionList(SurveyDimensionListSearchVo surveyDimensionVo);

    Integer getSurveyDimensionListTotalCount(SurveyDimensionListSearchVo surveyDimensionVo);

    SurveyDimension createSurveyDimension(SurveyDimension surveyDimension);

    SurveyDimension updateSurveyDimension(SurveyDimension surveyDimension);
}

