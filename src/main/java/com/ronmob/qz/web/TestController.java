package com.ronmob.qz.web;

import com.google.gson.Gson;
import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.service.*;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    SurveyDimensionService surveyDimensionService;

    @Autowired
    SurveyDimensionScoreTextService surveyDimensionScoreTextService;

    @Autowired
    UserScoreLogService userScoreLogService;

    @Autowired
    UserDistributionService userDistributionService;

    @Autowired
    UserSurveyService userSurveyService;


    @RequestMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public Object getSurveyClasses(HttpSession httpSession) {
        User user = new User();
        user.setUserName("Jeffrey");
        user.setIsAgent((byte) 0);
        user.setBalance(new BigDecimal(20));
        user.setScore(20);
        user.setWxOpenId("lkasiuuyqkjsdfouoipuoh2yu3");
        userService.createUser(user);

        SearchVo vo = new SearchVo();
        vo.setPage(new Page());

        return userService.getUserList(vo);
    }

    @RequestMapping(value = "/user", produces = "application/json")
    @ResponseBody
    public Object testUserService(@RequestBody SearchVo vo, HttpSession httpSession) {
        return userService.getUserList(vo);
    }

    @RequestMapping(value = "/p", produces = "application/json")
    @ResponseBody
    public Object testParams(@RequestBody SearchVo vo, HttpSession httpSession) throws Exception {
        Gson gson = new Gson();
        System.out.println(Util.getDateFromString(vo.getParams().get("starTime").toString()));
        System.out.println(gson.toJson(vo));

        return vo;
    }

}
