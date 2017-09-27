package com.ronmob.qz.dao;

import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.model.SurveyQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyQuestionMapper {
    long countByExample(SurveyQuestionExample example);

    int deleteByExample(SurveyQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SurveyQuestion record);

    int insertSelective(SurveyQuestion record);

    List<SurveyQuestion> selectByExampleWithBLOBs(SurveyQuestionExample example);

    List<SurveyQuestion> selectByExample(SurveyQuestionExample example);

    SurveyQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SurveyQuestion record, @Param("example") SurveyQuestionExample example);

    int updateByExampleWithBLOBs(@Param("record") SurveyQuestion record, @Param("example") SurveyQuestionExample example);

    int updateByExample(@Param("record") SurveyQuestion record, @Param("example") SurveyQuestionExample example);

    int updateByPrimaryKeySelective(SurveyQuestion record);

    int updateByPrimaryKeyWithBLOBs(SurveyQuestion record);

    int updateByPrimaryKey(SurveyQuestion record);
}