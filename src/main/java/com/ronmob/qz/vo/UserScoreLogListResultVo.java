package com.ronmob.qz.vo;

import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.model.common.Page;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public class UserScoreLogListResultVo {
    private Page page;
    private List<UserScoreLog> userScoreLogList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<UserScoreLog> getUserScoreLogList() {
        return userScoreLogList;
    }

    public void setUserScoreLogList(List<UserScoreLog> userScoreLogList) {
        this.userScoreLogList = userScoreLogList;
    }
}
