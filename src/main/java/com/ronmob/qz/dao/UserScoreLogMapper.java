package com.ronmob.qz.dao;

import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.vo.UserScoreLogListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface UserScoreLogMapper {
    List<UserScoreLog> getUserScoreLogList(UserScoreLogListSearchVo vo);

    Integer getUserScoreLogListTotalCount(UserScoreLogListSearchVo vo);

    Integer InsertUserScoreLog(UserScoreLog userScoreLog);

    Integer UpdateUserScoreLog(UserScoreLog userScoreLog);
}
