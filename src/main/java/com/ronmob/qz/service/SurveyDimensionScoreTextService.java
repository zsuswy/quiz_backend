package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.vo.SearchVo;
import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface SurveyDimensionScoreTextService {
    List<SurveyDimensionScoreText> getSurveyDimensionScoreTextList(SearchVo searchVo);

    Integer getSurveyDimensionsScoreTextListTotalCount(SearchVo searchVo);

    SurveyDimensionScoreText createSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText);

    SurveyDimensionScoreText updateSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText);

    Integer deleteSurveyDimensionScoreTextById(Integer id);
}
