package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.SurveyQuestionMapper;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.model.SurveyQuestionExample;
import com.ronmob.qz.service.SurveyQuestionService;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SurveyQuestionServiceImpl implements SurveyQuestionService {
    @Autowired
    private SurveyQuestionMapper surveyQuestionMapper;

    private SurveyQuestionExample getSurveyQuestionExample(SurveyQuestionListSearchVo vo) {
        SurveyQuestionExample example = new SurveyQuestionExample();
        return example;
    }

    @Override
    public List<SurveyQuestion> getSurveyQuestionList(SurveyQuestionListSearchVo surveyQuestionVo) {
        SurveyQuestionExample example = getSurveyQuestionExample(surveyQuestionVo);

        return surveyQuestionMapper.selectByExample(example);
    }

    @Override
    public Integer getSurveyQuestionListTotalCount(SurveyQuestionListSearchVo surveyQuestionVo) {
        SurveyQuestionExample example = getSurveyQuestionExample(surveyQuestionVo);

        return ((Long) surveyQuestionMapper.countByExample(example)).intValue();
    }

    @Override
    public SurveyQuestion createSurveyQuestion(SurveyQuestion surveyQuestion) {
        surveyQuestionMapper.insert(surveyQuestion);

        return surveyQuestion;
    }

    @Override
    public SurveyQuestion updateSurveyQuestion(SurveyQuestion surveyQuestion) {
        SurveyQuestion oldQuestion = surveyQuestionMapper.selectByPrimaryKey(surveyQuestion.getId());
        System.out.println(surveyQuestion);
        System.out.println(oldQuestion);

        // 如果 seq 被更新过，那么需要调换 seq
        if (oldQuestion.getSeq() != surveyQuestion.getSeq()) {

            SurveyQuestionExample exam = new SurveyQuestionExample();
            exam.createCriteria().andSeqEqualTo(surveyQuestion.getSeq());
            exam.createCriteria().andSurveyIdEqualTo(surveyQuestion.getSurveyId());

            // 查找是否有需要更新序号的问题
            SurveyQuestion questionOfSeqToChange = surveyQuestionMapper.selectByExample(exam).get(0);

            if (questionOfSeqToChange != null) {
                questionOfSeqToChange.setSeq(oldQuestion.getSeq());
                surveyQuestionMapper.updateByPrimaryKey(questionOfSeqToChange);
            }
        }

        surveyQuestionMapper.updateByPrimaryKey(surveyQuestion);

        return surveyQuestion;
    }

}
