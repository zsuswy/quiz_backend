package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.UserDistribution;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.UserDistributionService;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserDistributionService userDistributionService;

    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveys(HttpSession httpSession, @RequestBody SearchVo searchVo) {
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
    public ResponseResult insertSurvey(HttpSession httpSession, @RequestBody User user) {
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
    public ResponseResult updateSurvey(HttpSession httpSession, @RequestBody User user) {
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
    public ResponseResult shareSurvey(HttpSession httpSession, @RequestBody Map params) {
        ResponseResult result = new ResponseResult();
        try {
            User user = new User();
            user.setId(Util.getInteger(params.get("userId").toString()));

            SearchVo searchVo = new SearchVo();
            HashMap<String, Object> ps = new HashMap<>();
            ps.put("userId", params.get("userId"));
            ps.put("surveyId", params.get("userId"));
            searchVo.setParams(ps);
            searchVo.setPage(null);

            // 如果没有分享过，那么
            if (userDistributionService.getUserDistributionListTotalCount(searchVo) == 0) {

                UserDistribution userDistribution = new UserDistribution();
                userDistribution.setFromUserId(Util.getInteger(params.get("fromUserId").toString()));
                // userDistribution.setToUserId(Util.getInteger(params.get("toUserId").toString()));
                userDistribution.setSurveyId(Util.getInteger(params.get("surveyId").toString()));
                userDistributionService.createUserDistribution(userDistribution);

                user.setScore(2);
                this.userService.addScoreBalance(user);
            }
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

}