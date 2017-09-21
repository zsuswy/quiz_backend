package com.ronmob.qz.web;

import com.ronmob.qz.model.User;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.service.*;
import com.ronmob.qz.vo.UserListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

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

        UserListSearchVo vo = new UserListSearchVo();
        vo.setPage(new Page());

        return userService.getUserList(vo);
    }

}
