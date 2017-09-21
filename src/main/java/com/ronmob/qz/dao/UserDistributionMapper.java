package com.ronmob.qz.dao;

import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.model.UserDistributionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDistributionMapper {
    long countByExample(UserDistributionExample example);

    int deleteByExample(UserDistributionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDistribution record);

    int insertSelective(UserDistribution record);

    List<UserDistribution> selectByExample(UserDistributionExample example);

    UserDistribution selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDistribution record, @Param("example") UserDistributionExample example);

    int updateByExample(@Param("record") UserDistribution record, @Param("example") UserDistributionExample example);

    int updateByPrimaryKeySelective(UserDistribution record);

    int updateByPrimaryKey(UserDistribution record);
}