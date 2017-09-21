package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.SurveyQuestionMapper;
import com.ronmob.qz.model.SurveyQuestion;
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


    @Override
    public List<SurveyQuestion> getSurveyQuestionList(SurveyQuestionListSearchVo surveyQuestionVo) {
        return surveyQuestionMapper.getSurveyQuestionList(surveyQuestionVo);
    }

    @Override
    public Integer getSurveyQuestionListTotalCount(SurveyQuestionListSearchVo surveyQuestionVo) {
        return surveyQuestionMapper.getSurveyQuestionListTotalCount(surveyQuestionVo);
    }

    @Override
    public SurveyQuestion createSurveyQuestion(SurveyQuestion surveyQuestion) {
        surveyQuestionMapper.insertSurveyQuestion(surveyQuestion);

        return surveyQuestion;
    }

    @Override
    public SurveyQuestion updateSurveyQuestion(SurveyQuestion surveyQuestion) {
        SurveyQuestion oldQuestion = surveyQuestionMapper.getSurveyQuestionById(surveyQuestion.getId());
        System.out.println(surveyQuestion);
        System.out.println(oldQuestion);

        System.out.println("" + surveyQuestion.getId() + ":" + surveyQuestion.getSeq());
        System.out.println("" + oldQuestion.getId() + ":" + oldQuestion.getSeq());
        System.out.println("cao ni mei : " + (oldQuestion.getSeq() != surveyQuestion.getSeq()));
        // 如果 seq 被更新过，那么需要调换 seq
        if (oldQuestion.getSeq() != surveyQuestion.getSeq()) {
            System.out.println("fffffasdfasdfasdf");

            // 查找是否有需要更新序号的问题
            SurveyQuestion questionOfSeqToChange = surveyQuestionMapper.getSurveyQuestionBySeq(surveyQuestion.getSeq(),
                    surveyQuestion.getSurvey_id());

            System.out.println("1111111111111");

            System.out.println("surveyQuestion.getSeq() :" + surveyQuestion.getSeq());
            System.out.println("2222222222");

            System.out.println("surveyQuestion.getSurvey_id():" + surveyQuestion.getSurvey_id());
            System.out.println("333333333");

            System.out.println(questionOfSeqToChange);
            System.out.println("444444444444");
            System.out.println(questionOfSeqToChange != null);

            if (questionOfSeqToChange != null) {
                questionOfSeqToChange.setSeq(oldQuestion.getSeq());
                surveyQuestionMapper.updateSurveyQuestion(questionOfSeqToChange);
            }
        }

        surveyQuestionMapper.updateSurveyQuestion(surveyQuestion);

        return surveyQuestion;
    }

}
