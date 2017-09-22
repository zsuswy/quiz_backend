package com.ronmob.qz.service;

import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public interface UserDistributionService {
    List<UserDistribution> getUserDistributionList(SearchVo searchVo) throws Exception;

    Integer getUserDistributionListTotalCount(SearchVo searchVo) throws Exception;

    UserDistribution createUserDistribution(UserDistribution userDistribution) throws Exception;

    UserDistribution updateUserDistribution(UserDistribution userDistribution) throws Exception;

    Integer deleteUserDistribution(Integer id) throws Exception;
}
