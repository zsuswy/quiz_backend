package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.UserScoreLogMapper;
import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.model.UserScoreLogExample;
import com.ronmob.qz.service.UserScoreLogService;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
@Service
public class UserScoreLogServiceImpl implements UserScoreLogService {
    @Autowired
    UserScoreLogMapper userScoreLogMapper;

    private UserScoreLogExample getUserScoreLogxample(SearchVo searchVo) {
        UserScoreLogExample example = new UserScoreLogExample();
        return example;
    }

    @Override
    public List<UserScoreLog> getUserScoreLogList(SearchVo searchVo) {
        UserScoreLogExample example = getUserScoreLogxample(searchVo);

        return userScoreLogMapper.selectByExample(example);
    }

    @Override
    public Integer getUserScoreLogListTotalCount(SearchVo searchVo) {
        UserScoreLogExample example = getUserScoreLogxample(searchVo);

        return ((Long)userScoreLogMapper.countByExample(example)).intValue();
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
