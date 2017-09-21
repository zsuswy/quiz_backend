package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.UserSurveyMapper;
import com.ronmob.qz.model.UserScoreLog;
import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.UserSurveyListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class UserSurveyServiceImpl implements UserSurveyService {
    @Autowired
    UserSurveyMapper userSurveyMapper;

    @Override
    public List<UserSurvey> getUserSurveyList(UserSurveyListSearchVo userSurveyListSearchVo) {
        return userSurveyMapper.getUserSurveyList(userSurveyListSearchVo);
    }

    @Override
    public Integer getUserSurveyListTotalCount(UserSurveyListSearchVo userSurveyListSearchVo) {
        return userSurveyMapper.getUserSurveyListTotalCount(userSurveyListSearchVo);
    }

    @Override
    public UserSurvey createUserSurvey(UserSurvey userSurvey) {
        userSurveyMapper.insertUserSurvey(userSurvey);
        return userSurvey;
    }

    @Override
    public UserSurvey updateUserSurvey(UserSurvey userSurvey) {
        userSurveyMapper.updateUserSurvey(userSurvey);
        return userSurvey;
    }
}
