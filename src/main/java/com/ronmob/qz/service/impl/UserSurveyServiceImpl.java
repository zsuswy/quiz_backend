package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.UserSurveyMapper;
import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.UserSurveyExample;
import com.ronmob.qz.model.UserSurveyWithBLOBs;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class UserSurveyServiceImpl implements UserSurveyService {
    @Autowired
    UserSurveyMapper userSurveyMapper;

    private UserSurveyExample getUserExample(SearchVo searchVo) {
        UserSurveyExample example = new UserSurveyExample();
        return example;
    }

    @Override
    public List<UserSurvey> getUserSurveyList(SearchVo searchVo) {
        UserSurveyExample example = getUserExample(searchVo);
        return userSurveyMapper.selectByExample(example);
    }

    @Override
    public Integer getUserSurveyListTotalCount(SearchVo searchVo) {
        UserSurveyExample example = getUserExample(searchVo);

        return ((Long) userSurveyMapper.countByExample(example)).intValue();
    }

    @Override
    public UserSurveyWithBLOBs createUserSurvey(UserSurveyWithBLOBs userSurvey) {
        userSurveyMapper.insert(userSurvey);
        return userSurvey;
    }

    @Override
    public UserSurveyWithBLOBs updateUserSurvey(UserSurveyWithBLOBs userSurvey) {
        userSurveyMapper.updateByPrimaryKeySelective(userSurvey);
        return userSurvey;
    }
}
