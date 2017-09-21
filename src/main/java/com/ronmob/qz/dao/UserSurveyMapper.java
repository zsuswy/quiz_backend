package com.ronmob.qz.dao;

import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.vo.UserSurveyListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface UserSurveyMapper {
    List<UserSurvey> getUserSurveyList(UserSurveyListSearchVo vo);

    Integer getUserSurveyListTotalCount(UserSurveyListSearchVo vo);

    Integer insertUserSurvey(UserSurvey userSurvey);

    Integer updateUserSurvey(UserSurvey userSurvey);
}
