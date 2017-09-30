package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.SurveyQuestionMapper;
import com.ronmob.qz.model.SurveyExample;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.model.SurveyQuestionExample;
import com.ronmob.qz.service.SurveyQuestionService;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class SurveyQuestionServiceImpl implements SurveyQuestionService {
    @Autowired
    private SurveyQuestionMapper surveyQuestionMapper;

    private SurveyQuestionExample getSurveyQuestionExample(SearchVo searchVo) {
        SurveyQuestionExample example = new SurveyQuestionExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        Map params = searchVo.getParams();
        if (params.containsKey("id")) {
            example.createCriteria().andIdEqualTo(new Integer(params.get("id").toString()));
        }
        if (params.containsKey("seq")) {
            example.createCriteria().andSeqEqualTo(new Integer(params.get("seq").toString()));
        }
        if (params.containsKey("surveyId")) {
            example.createCriteria().andSurveyIdEqualTo(new Integer(params.get("surveyId").toString()));
        }
        if (params.containsKey("title")) {
            example.createCriteria().andTitleLike('%' + params.get("title").toString() + '%');
        }
        if (params.containsKey("type")) {
            example.createCriteria().andTypeEqualTo(new Byte(params.get("type").toString()));
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
//        SurveyQuestion oldQuestion = surveyQuestionMapper.selectByPrimaryKey(surveyQuestion.getId());
//        System.out.println(surveyQuestion);
//        System.out.println(oldQuestion);

//        // 如果 seq 被更新过，那么需要调换 seq
//        if (oldQuestion.getSeq() != surveyQuestion.getSeq()) {
//
//            SurveyQuestionExample exam = new SurveyQuestionExample();
//            exam.createCriteria().andSeqEqualTo(surveyQuestion.getSeq());
//            exam.createCriteria().andSurveyIdEqualTo(surveyQuestion.getSurveyId());
//
//            // 查找是否有需要更新序号的问题
//            SurveyQuestion questionOfSeqToChange = surveyQuestionMapper.selectByExample(exam).get(0);
//
//            if (questionOfSeqToChange != null) {
//                questionOfSeqToChange.setSeq(oldQuestion.getSeq());
//                surveyQuestionMapper.updateByPrimaryKey(questionOfSeqToChange);
//            }
//        }

        surveyQuestionMapper.updateByPrimaryKeyWithBLOBs(surveyQuestion);

        return surveyQuestion;
    }

    @Override
    public Integer deleteSurveyQuestionById(Integer id) throws Exception {
        return surveyQuestionMapper.deleteByPrimaryKey(id);
    }
}
