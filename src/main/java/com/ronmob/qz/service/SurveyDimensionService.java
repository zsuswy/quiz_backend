package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Repository
public interface SurveyDimensionService {
    List<SurveyDimension> getSurveyDimensionList(SearchVo searchVo) throws Exception;

    Integer getSurveyDimensionListTotalCount(SearchVo searchVo) throws Exception;

    SurveyDimension createSurveyDimension(SurveyDimension surveyDimension) throws Exception;

    SurveyDimension updateSurveyDimension(SurveyDimension surveyDimension) throws Exception;

    Integer deleteSurveyDimension(Integer id) throws Exception;
}

