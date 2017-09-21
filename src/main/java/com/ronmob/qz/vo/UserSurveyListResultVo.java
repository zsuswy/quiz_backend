package com.ronmob.qz.vo;

import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.common.Page;

import java.util.List;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
public class UserSurveyListResultVo {
    private Page page;
    private List<UserSurvey> userSurveyList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<UserSurvey> getUserSurveyList() {
        return userSurveyList;
    }

    public void setUserSurveyList(List<UserSurvey> userSurveyList) {
        this.userSurveyList = userSurveyList;
    }
}
