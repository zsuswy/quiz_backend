package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.UserDistributionMapper;
import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.model.UserDistributionExample;
import com.ronmob.qz.service.UserDistributionService;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.UserDistributionListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
@Service
public class UserDistributionServiceImpl implements UserDistributionService {
    @Autowired
    UserDistributionMapper userDistributionMapper;

    private UserDistributionExample getUserDistributionExample(UserDistributionListSearchVo vo) {
        UserDistributionExample example = new UserDistributionExample();
        return example;
    }

    @Override
    public List<UserDistribution> getUserDistributionList(UserDistributionListSearchVo userDistributionListSearchVo) {
        UserDistributionExample example = getUserDistributionExample(userDistributionListSearchVo);

        return userDistributionMapper.selectByExample(example);
    }

    @Override
    public Integer getUserDistributionListTotalCount(UserDistributionListSearchVo userDistributionListSearchVo) {
        UserDistributionExample example = getUserDistributionExample(userDistributionListSearchVo);

        return ((Long) userDistributionMapper.countByExample(example)).intValue();
    }

    @Override
    public UserDistribution createUserDistribution(UserDistribution userDistribution) {
        userDistributionMapper.insert(userDistribution);
        return userDistribution;
    }

    @Override
    public UserDistribution updateUserDistribution(UserDistribution userDistribution) {
        userDistributionMapper.updateByPrimaryKey(userDistribution);
        return userDistribution;
    }

    @Override
    public Integer deleteUserDistribution(Integer id) {

        return userDistributionMapper.deleteByPrimaryKey(id);
    }
}
