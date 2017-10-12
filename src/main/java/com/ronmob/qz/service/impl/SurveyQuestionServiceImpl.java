package com.ronmob.qz.service.impl;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.dao.SurveyQuestionMapper;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.model.SurveyQuestionExample;
import com.ronmob.qz.service.SurveyQuestionService;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class SurveyQuestionServiceImpl implements SurveyQuestionService {

    private static Log logger = LogFactory.getLog(SurveyQuestionServiceImpl.class);

    @Autowired
    private SurveyQuestionMapper surveyQuestionMapper;

    private SurveyQuestionExample getSurveyQuestionExample(SearchVo searchVo) {
        SurveyQuestionExample example = new SurveyQuestionExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        Map params = searchVo.getParams();

        SurveyQuestionExample.Criteria criteria = example.createCriteria();

        if (params.containsKey("id")) {
            criteria.andIdEqualTo(Util.getInteger(params.get("id").toString()));
        }
        if (params.containsKey("seq")) {
            criteria.andSeqEqualTo(Util.getInteger(params.get("seq").toString()));
        }
        if (params.containsKey("surveyId")) {
            criteria.andSurveyIdEqualTo(Util.getInteger(params.get("surveyId").toString()));
        }
        if (params.containsKey("title")) {
            criteria.andTitleLike('%' + params.get("title").toString() + '%');
        }
        if (params.containsKey("type")) {
            criteria.andTypeEqualTo(Util.getByte(params.get("type").toString()));
        }
        return example;
    }

    @Override
    public List<SurveyQuestion> getSurveyQuestionList(SearchVo searchVo) {
        SurveyQuestionExample example = getSurveyQuestionExample(searchVo);

        return surveyQuestionMapper.selectByExample(example);
    }

    @Override
    public List<SurveyQuestion> getSurveyQuestionListWithBlobs(SearchVo searchVo) {
        SurveyQuestionExample example = getSurveyQuestionExample(searchVo);

        return surveyQuestionMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public SurveyQuestion getSurveyQuestion(Integer id) {
        return surveyQuestionMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getSurveyQuestionListTotalCount(SearchVo searchVo) {
        SurveyQuestionExample example = getSurveyQuestionExample(searchVo);

        return ((Long) surveyQuestionMapper.countByExample(example)).intValue();
    }

    @Override
    public SurveyQuestion createSurveyQuestion(SurveyQuestion surveyQuestion) {
        surveyQuestionMapper.insert(surveyQuestion);

        return surveyQuestion;
    }

    @Override
    public SurveyQuestion updateSurveyQuestion(SurveyQuestion surveyQuestion) {
        surveyQuestionMapper.updateByPrimaryKeyWithBLOBs(surveyQuestion);

        return surveyQuestion;
    }

    @Override
    public Integer deleteSurveyQuestionById(Integer id) throws Exception {
        return surveyQuestionMapper.deleteByPrimaryKey(id);
    }
}
