package com.ronmob.qz.service;

import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.vo.UserSurveyListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface UserSurveyService {
    List<UserSurvey> getUserSurveyList(UserSurveyListSearchVo userSurveyListSearchVo);

    Integer getUserSurveyListTotalCount(UserSurveyListSearchVo userSurveyListSearchVo);

    UserSurvey createUserSurvey(UserSurvey userSurvey);

    UserSurvey updateUserSurvey(UserSurvey userSurvey);
}
