package com.ronmob.qz.service.impl;

import com.alibaba.fastjson.JSON;
import com.ronmob.qz.common.Util;
import com.ronmob.qz.dao.UserSurveyMapper;
import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.UserSurveyExample;
import com.ronmob.qz.model.UserSurveyWithBLOBs;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class UserSurveyServiceImpl implements UserSurveyService {
    @Autowired
    UserSurveyMapper userSurveyMapper;

    private UserSurveyExample getUserExample(SearchVo searchVo) throws Exception {
        UserSurveyExample example = new UserSurveyExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        Map params = searchVo.getParams();

        UserSurveyExample.Criteria criteria = example.createCriteria();
        if (params.containsKey("id")) {
            criteria.andIdEqualTo(Util.getInteger(params.get("id").toString()));
        }
        if (params.containsKey("userId")) {
            criteria.andUserIdEqualTo(Util.getInteger(params.get("userId").toString()));
        }
        if (params.containsKey("pUserId")) {
            criteria.andPUserIdEqualTo(Util.getInteger(params.get("pUserId").toString()));
        }
        if (params.containsKey("surveyId")) {
            criteria.andSurveyIdEqualTo(Util.getInteger(params.get("surveyId").toString()));
        }
        if (params.containsKey("status")) {
            criteria.andStatusEqualTo(Util.getByte(params.get("status").toString()));
        }
        if (params.containsKey("createTime_Start")) {
            criteria.andCreateTimeGreaterThanOrEqualTo(Util.getDateFromString(params.get("createTime_Start").toString()));
        }
        if (params.containsKey("createTime_End")) {
            criteria.andCreateTimeLessThanOrEqualTo(Util.getDateFromString(params.get("createTime_End").toString()));
        }

        return example;
    }

    @Override
    public List<UserSurvey> getUserSurveyList(SearchVo searchVo) throws Exception {
        UserSurveyExample example = getUserExample(searchVo);
        return userSurveyMapper.selectByExample(example);
    }

    @Override
    public List<UserSurvey> getUserSurveyDetailList(SearchVo searchVo) throws Exception {
        UserSurveyExample example = getUserExample(searchVo);
        return userSurveyMapper.selectByExampleWithDetail(example);
    }

    @Override
    public UserSurveyWithBLOBs getUserSurvey(Integer id) {
        return userSurveyMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getUserSurveyListTotalCount(SearchVo searchVo) throws Exception {
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
        userSurveyMapper.updateByPrimaryKeyWithBLOBs(userSurvey);
        return userSurvey;
    }

    @Override
    public UserSurvey updateUserSurvey(UserSurvey userSurvey) throws Exception {
        userSurveyMapper.updateByPrimaryKey(userSurvey);
        return userSurvey;
    }
}
