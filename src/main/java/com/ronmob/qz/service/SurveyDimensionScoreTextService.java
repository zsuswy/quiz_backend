package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface SurveyDimensionScoreTextService {
    List<SurveyDimensionScoreText> getSurveyDimensionScoreTextList(SearchVo searchVo) throws Exception;

    List<SurveyDimensionScoreText> getSurveyDimensionScoreTextWithBLOBsList(SearchVo searchVo) throws Exception;

    SurveyDimensionScoreText getSurveyDimensionScoreText(Integer id);

    Integer getSurveyDimensionsScoreTextListTotalCount(SearchVo searchVo) throws Exception;

    SurveyDimensionScoreText createSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText) throws Exception;

    SurveyDimensionScoreText updateSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText) throws Exception;

    Integer deleteSurveyDimensionScoreTextById(Integer id) throws Exception;
}
