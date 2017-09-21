package com.ronmob.qz.dao;

import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.vo.UserDistributionListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface UserDistributionMapper {
    List<UserDistribution> getUserDistributionList(UserDistributionListSearchVo vo);

    Integer getUserDistributionListTotalCount(UserDistributionListSearchVo vo);

    Integer InsertUserDistribution(UserDistribution userDistribution);

    Integer UpdateUserDistribution(UserDistribution userDistribution);

    Integer DeleteuserDistribution(Integer id);
}
