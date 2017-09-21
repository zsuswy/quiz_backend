package com.ronmob.qz.dao;

import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.vo.SurveyDimensionListSearchVo;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;

import java.util.List;

public interface SurveyDimensionMapper {
    // ------------------------ SurveyDimension 相关操作 ------------------------
    List<SurveyDimension> getSurveyDimensions(SurveyDimensionListSearchVo surveyDimensionListSearchVo);

    Integer getSurveyDimesionTotalCount(SurveyDimensionListSearchVo surveyDimensionListSearchVo);

    Integer insertSurveyDimension(SurveyDimension surveyDimension);

    Integer updateSurveyDimension(SurveyDimension surveyDimension);

    Integer deleteSurveyDimension(Integer id);
}