package com.ronmob.qz.dao;

import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.UserSurveyExample;
import com.ronmob.qz.model.UserSurveyWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserSurveyMapper {
    long countByExample(UserSurveyExample example);

    int deleteByExample(UserSurveyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserSurveyWithBLOBs record);

    int insertSelective(UserSurveyWithBLOBs record);

    List<UserSurveyWithBLOBs> selectByExampleWithBLOBs(UserSurveyExample example);

    List<UserSurvey> selectByExample(UserSurveyExample example);

    List<UserSurvey> selectByExampleWithDetail(UserSurveyExample example);

    UserSurveyWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserSurveyWithBLOBs record, @Param("example") UserSurveyExample example);

    int updateByExampleWithBLOBs(@Param("record") UserSurveyWithBLOBs record, @Param("example") UserSurveyExample example);

    int updateByExample(@Param("record") UserSurvey record, @Param("example") UserSurveyExample example);

    int updateByPrimaryKeySelective(UserSurveyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserSurveyWithBLOBs record);

    int updateByPrimaryKey(UserSurvey record);
}