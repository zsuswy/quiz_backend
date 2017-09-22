package com.ronmob.qz.service;

import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public interface UserScoreLogService {
    List<UserScoreLog> getUserScoreLogList(SearchVo searchVo);

    Integer getUserScoreLogListTotalCount(SearchVo searchVo);

    UserScoreLog createUserScoreLog(UserScoreLog userDistribution);

    UserScoreLog updateUserScoreLog(UserScoreLog userDistribution);
}
