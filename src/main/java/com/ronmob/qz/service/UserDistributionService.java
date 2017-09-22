package com.ronmob.qz.service;

import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public interface UserDistributionService {
    List<UserDistribution> getUserDistributionList(SearchVo searchVo);

    Integer getUserDistributionListTotalCount(SearchVo searchVo);

    UserDistribution createUserDistribution(UserDistribution userDistribution);

    UserDistribution updateUserDistribution(UserDistribution userDistribution);

    Integer deleteUserDistribution(Integer id);
}
