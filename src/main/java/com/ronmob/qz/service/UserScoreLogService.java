package com.ronmob.qz.service;

import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public interface UserScoreLogService {
    List<UserScoreLog> getUserScoreLogList(SearchVo searchVo) throws Exception;

    Integer getUserScoreLogListTotalCount(SearchVo searchVo) throws Exception;

    UserScoreLog createUserScoreLog(UserScoreLog userDistribution) throws Exception;

    UserScoreLog updateUserScoreLog(UserScoreLog userDistribution) throws Exception;
}
