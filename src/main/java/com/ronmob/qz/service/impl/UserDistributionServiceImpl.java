package com.ronmob.qz.service.impl;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.dao.UserDistributionMapper;
import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.model.UserDistributionExample;
import com.ronmob.qz.service.UserDistributionService;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
@Service
public class UserDistributionServiceImpl implements UserDistributionService {
    @Autowired
    UserDistributionMapper userDistributionMapper;

    private UserDistributionExample getUserDistributionExample(SearchVo searchVo) {
        UserDistributionExample example = new UserDistributionExample();

        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        Map params = searchVo.getParams();

        UserDistributionExample.Criteria criteria = example.createCriteria();

        if (params.containsKey("id")) {
            criteria.andIdEqualTo(Util.getInteger(params.get("id").toString()));
        }
        if (params.containsKey("fromUserId")) {
            criteria.andFromUserIdEqualTo(Util.getInteger(params.get("fromUserId").toString()));
        }
        if (params.containsKey("toUserId")) {
            criteria.andToUserIdEqualTo(Util.getInteger(params.get("toUserId").toString()));
        }
        if (params.containsKey("surveyId")) {
            criteria.andSurveyIdEqualTo(Util.getInteger(params.get("surveyId").toString()));
        }
        if (params.containsKey("userSurveyId")) {
            criteria.andUserSurveyIdEqualTo(Util.getInteger(params.get("userSurveyId").toString()));
        }

        return example;
    }

    @Override
    public List<UserDistribution> getUserDistributionList(SearchVo searchVo) {
        UserDistributionExample example = getUserDistributionExample(searchVo);

        return userDistributionMapper.selectByExample(example);
    }

    @Override
    public UserDistribution getUserDistribution(Integer id) {
        return userDistributionMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getUserDistributionListTotalCount(SearchVo searchVo) {
        UserDistributionExample example = getUserDistributionExample(searchVo);

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
