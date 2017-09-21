package com.ronmob.qz.service;

import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.vo.UserDistributionListSearchVo;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public interface UserDistributionService {
    List<UserDistribution> getUserDistributionList(UserDistributionListSearchVo userDistributionListSearchVo);

    Integer getUserDistributionListTotalCount(UserDistributionListSearchVo userDistributionListSearchVo);

    UserDistribution createUserDistribution(UserDistribution userDistribution);

    UserDistribution updateUserDistribution(UserDistribution userDistribution);
}
