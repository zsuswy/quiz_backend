package com.ronmob.qz.dao;

import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.model.UserScoreLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserScoreLogMapper {
    long countByExample(UserScoreLogExample example);

    int deleteByExample(UserScoreLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserScoreLog record);

    int insertSelective(UserScoreLog record);

    List<UserScoreLog> selectByExample(UserScoreLogExample example);

    UserScoreLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserScoreLog record, @Param("example") UserScoreLogExample example);

    int updateByExample(@Param("record") UserScoreLog record, @Param("example") UserScoreLogExample example);

    int updateByPrimaryKeySelective(UserScoreLog record);

    int updateByPrimaryKey(UserScoreLog record);
}