package com.ronmob.qz.service;

import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.UserSurveyWithBLOBs;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface UserSurveyService {
    List<UserSurvey> getUserSurveyList(SearchVo searchVo);

    Integer getUserSurveyListTotalCount(SearchVo searchVo);

    UserSurveyWithBLOBs createUserSurvey(UserSurveyWithBLOBs userSurvey);

    UserSurveyWithBLOBs updateUserSurvey(UserSurveyWithBLOBs userSurvey);
}
