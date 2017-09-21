package com.ronmob.qz.service;

import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.vo.UserScoreLogListSearchVo;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public interface UserScoreLogService {
    List<UserScoreLog> getUserScoreLogList(UserScoreLogListSearchVo userScoreLogListSearchVo);

    Integer getUserScoreLogListTotalCount(UserScoreLogListSearchVo userScoreLogListSearchVo);

    UserScoreLog createUserScoreLog(UserScoreLog userDistribution);

    UserScoreLog updateUserScoreLog(UserScoreLog userDistribution);
}
