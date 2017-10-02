package com.ronmob.qz.service.impl;

import java.util.List;
import java.util.Map;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyExample;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronmob.qz.dao.SurveyMapper;
import com.ronmob.qz.service.SurveyService;

/**
 *
 */
@Service
public class SurveyServiceImpl implements SurveyService {
    public static void main(String[] args) {
        System.out.println(Byte.parseByte("1"));
    }

    @Autowired
    private SurveyMapper surveyMapper;

    private SurveyExample getSurveyExample(SearchVo searchVo) {
        SurveyExample example = new SurveyExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        Map params = searchVo.getParams();
        if (params.containsKey("id")) {
            example.createCriteria().andIdEqualTo(Integer.parseInt(params.get("id").toString()));
        }
        if (params.containsKey("status")) {
            example.createCriteria().andStatusEqualTo(Util.getByte(params.get("status").toString()));
        }
        if (params.containsKey("isHot")) {
            example.createCriteria().andIsHotEqualTo(Util.getByte(params.get("isHot").toString()));
        }
        if (params.containsKey("isNew")) {
            example.createCriteria().andIsNewEqualTo(Util.getByte(params.get("isNew").toString()));
        }
        if (params.containsKey("isSuper")) {
            example.createCriteria().andIsSuperEqualTo(Util.getByte(params.get("isSuper").toString()));
        }
        if (params.containsKey("classId")) {
            example.createCriteria().andClassIdEqualTo(Integer.parseInt(params.get("classId").toString()));
        }
        return example;
    }

    @Override
    public Survey getSurvey(Integer id) {
        return surveyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Survey> getSurveyList(SearchVo searchVo) {
        SurveyExample example = getSurveyExample(searchVo);

        return surveyMapper.selectByExample(example);
    }

    @Override
    public List<Survey> getSurveyWithBOLBsList(SearchVo searchVo) {
        SurveyExample example = getSurveyExample(searchVo);

        return surveyMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public Integer getSurveyListTotalCount(SearchVo searchVo) {
        SurveyExample example = getSurveyExample(searchVo);

        return ((Long) surveyMapper.countByExample(example)).intValue();
    }

    @Override
    public Survey createSurvey(Survey survey) {
        surveyMapper.insert(survey);
        return survey;
    }

    @Override
    public Survey updateSurvey(Survey survey) {
        surveyMapper.updateByPrimaryKeyWithBLOBs(survey);
        return survey;
    }
}
