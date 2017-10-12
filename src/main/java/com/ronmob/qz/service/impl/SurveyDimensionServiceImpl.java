package com.ronmob.qz.service.impl;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.dao.SurveyDimensionMapper;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyDimensionExample;
import com.ronmob.qz.service.SurveyDimensionService;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class SurveyDimensionServiceImpl implements SurveyDimensionService {
    private static Log logger = LogFactory.getLog(SurveyDimensionServiceImpl.class);

    @Autowired
    SurveyDimensionMapper surveyDimensionMapper;


    private SurveyDimensionExample getSurveyDimensionExample(SearchVo searchVo) {
        SurveyDimensionExample example = new SurveyDimensionExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        Map params = searchVo.getParams();

        SurveyDimensionExample.Criteria criteria = example.createCriteria();

        if (params.containsKey("id")) {
            criteria.andIdEqualTo(Util.getInteger(params.get("id").toString()));
        }
        if (params.containsKey("parentId")) {
            criteria.andParentIdEqualTo(Util.getInteger(params.get("parentId").toString()));
        }
        if (params.containsKey("surveyId")) {
            criteria.andSurveyIdEqualTo(Util.getInteger(params.get("surveyId").toString()));
        }
        if (params.containsKey("seq")) {
            criteria.andSeqEqualTo(Util.getInteger(params.get("seq").toString()));
        }
        return example;
    }

    @Override
    public List<SurveyDimension> getSurveyDimensionList(SearchVo searchVo) {
        SurveyDimensionExample example = getSurveyDimensionExample(searchVo);

        return surveyDimensionMapper.selectByExample(example);
    }

    @Override
    public SurveyDimension getSurveyDimension(Integer id) {
        return surveyDimensionMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getSurveyDimensionListTotalCount(SearchVo searchVo) {
        SurveyDimensionExample example = getSurveyDimensionExample(searchVo);

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
