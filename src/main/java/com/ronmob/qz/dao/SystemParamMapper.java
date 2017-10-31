package com.ronmob.qz.dao;

import com.ronmob.qz.model.SystemParam;
import com.ronmob.qz.model.SystemParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemParamMapper {
    long countByExample(SystemParamExample example);

    int deleteByExample(SystemParamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemParam record);

    int insertSelective(SystemParam record);

    List<SystemParam> selectByExample(SystemParamExample example);

    SystemParam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemParam record, @Param("example") SystemParamExample example);

    int updateByExample(@Param("record") SystemParam record, @Param("example") SystemParamExample example);

    int updateByPrimaryKeySelective(SystemParam record);

    int updateByPrimaryKey(SystemParam record);
}