package com.ronmob.qz.service;

import com.ronmob.qz.model.PayOrder;
import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.UserSurveyWithBLOBs;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface UserSurveyService {
    List<UserSurvey> getUserSurveyList(SearchVo searchVo) throws Exception;

    List<UserSurvey> getUserSurveyDetailList(SearchVo searchVo) throws Exception;

    UserSurveyWithBLOBs getUserSurvey(Integer id);

    UserSurveyWithBLOBs getUserSurveyByOrderId(Integer orderId);

    Integer getUserSurveyListTotalCount(SearchVo searchVo) throws Exception;

    Integer getPayedSurveyListTotalCount(SearchVo searchVo) throws Exception;

    UserSurveyWithBLOBs createUserSurvey(UserSurveyWithBLOBs userSurvey) throws Exception;

    UserSurvey createUserSurveyFromOrder(PayOrder order) throws Exception;

    UserSurveyWithBLOBs updateUserSurvey(UserSurveyWithBLOBs userSurvey) throws Exception;

    UserSurvey updateUserSurvey(UserSurvey userSurvey) throws Exception;
}