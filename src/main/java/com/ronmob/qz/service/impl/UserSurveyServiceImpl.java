package com.ronmob.qz.service.impl;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.dao.UserSurveyMapper;
import com.ronmob.qz.model.PayOrder;
import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.UserSurveyExample;
import com.ronmob.qz.model.UserSurveyWithBLOBs;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.service.WxHelper;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class UserSurveyServiceImpl implements UserSurveyService {
    private static Log logger = LogFactory.getLog(UserSurveyServiceImpl.class);

    @Autowired
    UserSurveyMapper userSurveyMapper;

    @Autowired
    WxHelper wxHelper;

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
            criteria.andFromUserIdEqualTo(Util.getInteger(params.get("pUserId").toString()));
        }
        if (params.containsKey("orderId")) {
            criteria.andOrderIdEqualTo(Util.getInteger(params.get("orderId").toString()));
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
    public UserSurveyWithBLOBs getUserSurveyByOrderId(Integer orderId) {
        UserSurveyExample example = new UserSurveyExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        return userSurveyMapper.selectByExampleWithBLOBs(example).get(0);
    }

    @Override
    public Integer getUserSurveyListTotalCount(SearchVo searchVo) throws Exception {
        UserSurveyExample example = getUserExample(searchVo);

        return ((Long) userSurveyMapper.countByExample(example)).intValue();
    }

    @Override
    public Integer getPayedSurveyListTotalCount(SearchVo searchVo) throws Exception {
        UserSurveyExample example = getUserExample(searchVo);
        example.getOredCriteria().get(0).andStatusGreaterThan(Util.getByte("0"));

        return ((Long) userSurveyMapper.countByExample(example)).intValue();
    }

    @Override
    public UserSurveyWithBLOBs createUserSurvey(UserSurveyWithBLOBs userSurvey) {
        userSurveyMapper.insert(userSurvey);
        return userSurvey;
    }

    @Override
    public UserSurvey createUserSurveyFromOrder(PayOrder order) throws Exception {
        // 创建userSurvey
        UserSurveyWithBLOBs userSurvey = new UserSurveyWithBLOBs();
        userSurvey.setUserId(order.getUserId());
        userSurvey.setSurveyId(order.getSurveyId());
        userSurvey.setOrderId(order.getId());
        userSurvey.setFromUserId(order.getFromUserId());
        userSurvey.setStatus(new Byte("0"));
        return this.createUserSurvey(userSurvey);
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
