package com.ronmob.qz.service.impl;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.dao.UserScoreLogMapper;
import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.model.UserScoreLogExample;
import com.ronmob.qz.service.UserScoreLogService;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
@Service
public class UserScoreLogServiceImpl implements UserScoreLogService {
    private static Log logger = LogFactory.getLog(UserScoreLogServiceImpl.class);

    @Autowired
    UserScoreLogMapper userScoreLogMapper;

    private UserScoreLogExample getUserScoreLogxample(SearchVo searchVo) throws Exception {
        UserScoreLogExample example = new UserScoreLogExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        Map params = searchVo.getParams();

        UserScoreLogExample.Criteria criteria = example.createCriteria();

        if (params.containsKey("id")) {
            criteria.andIdEqualTo(Util.getInteger(params.get("id").toString()));
        }
        if (params.containsKey("userId")) {
            criteria.andUserIdEqualTo(Util.getInteger(params.get("userId").toString()));
        }
        if (params.containsKey("type")) {
            criteria.andTypeEqualTo(Util.getByte(params.get("type").toString()));
        }
        if (params.containsKey("scoreTime_Start")) {
            criteria.andScoreTimeGreaterThanOrEqualTo(Util.getDateFromString(params.get("scoreTime_Start").toString()));
        }
        if (params.containsKey("scoreTime_End")) {
            criteria.andScoreTimeLessThanOrEqualTo(Util.getDateFromString(params.get("scoreTime_End").toString()));
        }
        return example;
    }

    @Override
    public List<UserScoreLog> getUserScoreLogList(SearchVo searchVo) throws Exception {
        UserScoreLogExample example = getUserScoreLogxample(searchVo);

        return userScoreLogMapper.selectByExample(example);
    }

    @Override
    public UserScoreLog getUserScoreLog(Integer id) {
        return userScoreLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getUserScoreLogListTotalCount(SearchVo searchVo) throws Exception {
        UserScoreLogExample example = getUserScoreLogxample(searchVo);

        return ((Long) userScoreLogMapper.countByExample(example)).intValue();
    }

    @Override
    public UserScoreLog createUserScoreLog(UserScoreLog userDistribution) {
        userScoreLogMapper.insert(userDistribution);
        return userDistribution;
    }

    @Override
    public UserScoreLog updateUserScoreLog(UserScoreLog userDistribution) {
        userScoreLogMapper.updateByPrimaryKey(userDistribution);
        return userDistribution;
    }
}
