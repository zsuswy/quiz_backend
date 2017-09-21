package com.ronmob.qz.vo;

import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.model.common.Page;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public class UserScoreLogListSearchVo {
    private Page page;
    private UserScoreLog userScoreLog;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public UserScoreLog getUserScoreLog() {
        return userScoreLog;
    }

    public void setUserScoreLog(UserScoreLog userScoreLog) {
        this.userScoreLog = userScoreLog;
    }
}
