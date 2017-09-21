package com.ronmob.qz.vo;

import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.common.Page;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public class UserSurveyListSearchVo {
    private Page page;
    private UserSurvey userSurvey;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public UserSurvey getUserSurvey() {
        return userSurvey;
    }

    public void setUserSurvey(UserSurvey userSurvey) {
        this.userSurvey = userSurvey;
    }
}
