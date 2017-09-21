package com.ronmob.qz.dao;

import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.SurveyDimensionScoreTextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyDimensionScoreTextMapper {
    long countByExample(SurveyDimensionScoreTextExample example);

    int deleteByExample(SurveyDimensionScoreTextExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SurveyDimensionScoreText record);

    int insertSelective(SurveyDimensionScoreText record);

    List<SurveyDimensionScoreText> selectByExampleWithBLOBs(SurveyDimensionScoreTextExample example);

    List<SurveyDimensionScoreText> selectByExample(SurveyDimensionScoreTextExample example);

    SurveyDimensionScoreText selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SurveyDimensionScoreText record, @Param("example") SurveyDimensionScoreTextExample example);

    int updateByExampleWithBLOBs(@Param("record") SurveyDimensionScoreText record, @Param("example") SurveyDimensionScoreTextExample example);

    int updateByExample(@Param("record") SurveyDimensionScoreText record, @Param("example") SurveyDimensionScoreTextExample example);

    int updateByPrimaryKeySelective(SurveyDimensionScoreText record);

    int updateByPrimaryKeyWithBLOBs(SurveyDimensionScoreText record);

    int updateByPrimaryKey(SurveyDimensionScoreText record);
}