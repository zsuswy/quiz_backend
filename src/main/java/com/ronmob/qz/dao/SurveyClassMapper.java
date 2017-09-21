package com.ronmob.qz.dao;

import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.model.SurveyClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyClassMapper {
    long countByExample(SurveyClassExample example);

    int deleteByExample(SurveyClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SurveyClass record);

    int insertSelective(SurveyClass record);

    List<SurveyClass> selectByExample(SurveyClassExample example);

    SurveyClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SurveyClass record, @Param("example") SurveyClassExample example);

    int updateByExample(@Param("record") SurveyClass record, @Param("example") SurveyClassExample example);

    int updateByPrimaryKeySelective(SurveyClass record);

    int updateByPrimaryKey(SurveyClass record);
}