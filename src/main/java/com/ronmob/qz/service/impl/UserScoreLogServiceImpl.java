package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.UserScoreLogMapper;
import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.service.UserScoreLogService;
import com.ronmob.qz.vo.UserScoreLogListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public class UserScoreLogServiceImpl implements UserScoreLogService {
    @Autowired
    UserScoreLogMapper userScoreLogMapper;

    @Override
    public List<UserScoreLog> getUserScoreLogList(UserScoreLogListSearchVo userScoreLogListSearchVo) {
        return userScoreLogMapper.getUserScoreLogList(userScoreLogListSearchVo);
    }

    @Override
    public Integer getUserScoreLogListTotalCount(UserScoreLogListSearchVo userScoreLogListSearchVo) {
        return userScoreLogMapper.getUserScoreLogListTotalCount(userScoreLogListSearchVo);
    }

    @Override
    public UserScoreLog createUserScoreLog(UserScoreLog userDistribution) {
        userScoreLogMapper.insertUserScoreLog(userDistribution);
        return userDistribution;
    }

    @Override
    public UserScoreLog updateUserScoreLog(UserScoreLog userDistribution) {
        userScoreLogMapper.updateUserScoreLog(userDistribution);
        return userDistribution;
    }
}
