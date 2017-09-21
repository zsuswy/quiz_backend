package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.UserDistributionMapper;
import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.service.UserDistributionService;
import com.ronmob.qz.vo.UserDistributionListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public class UserDistributionServiceImpl implements UserDistributionService {
    @Autowired
    UserDistributionMapper userDistributionMapper;

    @Override
    public List<UserDistribution> getUserDistributionList(UserDistributionListSearchVo userDistributionListSearchVo) {
        return userDistributionMapper.getUserDistributionList(userDistributionListSearchVo);
    }

    @Override
    public Integer getUserDistributionListTotalCount(UserDistributionListSearchVo userDistributionListSearchVo) {
        return userDistributionMapper.getUserDistributionListTotalCount(userDistributionListSearchVo);
    }

    @Override
    public UserDistribution createUserDistribution(UserDistribution userDistribution) {
        userDistributionMapper.insertUserDistribution(userDistribution);
        return userDistribution;
    }

    @Override
    public UserDistribution updateUserDistribution(UserDistribution userDistribution) {
        userDistributionMapper.updateUserDistribution(userDistribution);
        return userDistribution;
    }

    @Override
    public Integer deleteUserDistribution(Integer id) {
        return userDistributionMapper.deleteUserDistributionById(id);
    }
}
