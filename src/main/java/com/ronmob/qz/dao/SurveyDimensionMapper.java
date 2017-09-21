package com.ronmob.qz.dao;

import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.SurveyDimensionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyDimensionMapper {
    long countByExample(SurveyDimensionExample example);

    int deleteByExample(SurveyDimensionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SurveyDimension record);

    int insertSelective(SurveyDimension record);

    List<SurveyDimension> selectByExample(SurveyDimensionExample example);

    SurveyDimension selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SurveyDimension record, @Param("example") SurveyDimensionExample example);

    int updateByExample(@Param("record") SurveyDimension record, @Param("example") SurveyDimensionExample example);

    int updateByPrimaryKeySelective(SurveyDimension record);

    int updateByPrimaryKey(SurveyDimension record);
}