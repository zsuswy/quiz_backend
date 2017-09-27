package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.SurveyDimensionScoreTextMapper;
import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.SurveyDimensionScoreTextExample;
import com.ronmob.qz.service.SurveyDimensionScoreTextService;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class SurveyDimensionScoreTextServiceImpl implements SurveyDimensionScoreTextService {
    @Autowired
    SurveyDimensionScoreTextMapper surveyDimensionScoreTextMapper;

    private SurveyDimensionScoreTextExample getSurveyDimensionScoreTextExample(SearchVo searchVo) {
        SurveyDimensionScoreTextExample example = new SurveyDimensionScoreTextExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        Map params = searchVo.getParams();
        if (params.containsKey("dimensionId")) {
            example.createCriteria().andDimensionIdEqualTo(new Integer(params.get("dimensionId").toString()));
        }
        if (params.containsKey("id")) {
            example.createCriteria().andIdEqualTo(new Integer(params.get("id").toString()));
        }

        return example;
    }

    @Override
    public List<SurveyDimensionScoreText> getSurveyDimensionScoreTextList(SearchVo searchVo) {
        SurveyDimensionScoreTextExample example = getSurveyDimensionScoreTextExample(searchVo);

        return surveyDimensionScoreTextMapper.selectByExample(example);
    }

    @Override
    public SurveyDimensionScoreText getSurveyDimensionScoreText(Integer id) {
        return surveyDimensionScoreTextMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SurveyDimensionScoreText> getSurveyDimensionScoreTextWithBLOBsList(SearchVo searchVo) {
        SurveyDimensionScoreTextExample example = getSurveyDimensionScoreTextExample(searchVo);

        return surveyDimensionScoreTextMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public Integer getSurveyDimensionsScoreTextListTotalCount(SearchVo searchVo) {
        SurveyDimensionScoreTextExample example = getSurveyDimensionScoreTextExample(searchVo);

        return ((Long) surveyDimensionScoreTextMapper.countByExample(example)).intValue();
    }

    @Override
    public SurveyDimensionScoreText createSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText) {
        surveyDimensionScoreTextMapper.insert(surveyDimensionScoreText);
        return surveyDimensionScoreText;
    }

    @Override
    public SurveyDimensionScoreText updateSurveyDimensionScoreText(SurveyDimensionScoreText surveyDimensionScoreText) {
        surveyDimensionScoreTextMapper.updateByPrimaryKeyWithBLOBs(surveyDimensionScoreText);
        return surveyDimensionScoreText;
    }

    @Override
    public Integer deleteSurveyDimensionScoreTextById(Integer id) {
        return surveyDimensionScoreTextMapper.deleteByPrimaryKey(id);
    }
}
