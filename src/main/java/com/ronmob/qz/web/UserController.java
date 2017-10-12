package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.UserDistributionService;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserSurveyService userSurveyService;


    @Autowired
    private UserDistributionService userDistributionService;

    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveys(@RequestBody SearchVo searchVo) {
        ResponseResult result = new ResponseResult();
        ListResultData listResultData = new ListResultData();
        try {
            Page page = Util.getPageFromSearchVo(searchVo);
            if (page != null) {
                page.setTotalCount(userService.getUserListTotalCount(searchVo));
                listResultData.setPage(page);
            }

            listResultData.setList(this.userService.getUserList(searchVo));

            result.setSuccess(true);
            result.setData(listResultData);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/get", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurvey(Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            result.setSuccess(true);
            result.setData(this.userService.getUser(id));
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public ResponseResult insertSurvey(@RequestBody User user) {
        ResponseResult result = new ResponseResult();
        try {
            this.userService.createUser(user);
            result.setSuccess(true);
            result.setData(user);

        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseResult updateSurvey(@RequestBody User user) {
        ResponseResult result = new ResponseResult();
        try {
            this.userService.updateUser(user);
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/share", produces = "application/json")
    @ResponseBody
    public ResponseResult shareSurvey(HttpServletRequest req, @RequestBody Map params) {
        ResponseResult result = new ResponseResult();
        try {
            Integer userId = Util.getInteger(req.getHeader("Accept-Base"));
            Integer surveyId = Util.getInteger(params.get("surveyId").toString());

            this.shareSurvey(userId, surveyId);

            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @Transactional
    protected void shareSurvey(Integer userId, Integer surveyId) throws Exception {
        User user = new User();
        user.setId(userId);

        SearchVo userSurveySearchVo = new SearchVo();
        HashMap<String, Object> psUserSurvey = new HashMap<>();
        psUserSurvey.put("userId", userId);
        psUserSurvey.put("surveyId", surveyId);
        userSurveySearchVo.setParams(psUserSurvey);
        userSurveySearchVo.setPage(null);

        if (userSurveyService.getUserSurveyListTotalCount(userSurveySearchVo) == 0) {
            return;
        }

        SearchVo distributionSearchVo = new SearchVo();
        HashMap<String, Object> psDistSearchVo = new HashMap<>();
        psDistSearchVo.put("fromUserId", userId);
        psDistSearchVo.put("surveyId", surveyId);
        distributionSearchVo.setParams(psDistSearchVo);
        distributionSearchVo.setPage(null);
        // 如果没有分享过，那么
        if (userDistributionService.getUserDistributionListTotalCount(distributionSearchVo) == 0) {
            UserDistribution userDistribution = new UserDistribution();
            userDistribution.setFromUserId(userId);
            userDistribution.setSurveyId(surveyId);
            userDistributionService.createUserDistribution(userDistribution);
            user.setScore(new BigDecimal(2));
            this.userService.addScoreBalance(user);
        }
    }

}