package com.ronmob.qz.web;

import com.google.gson.Gson;
import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
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
        //userService.createUser(user);

        SearchVo vo = new SearchVo();
        vo.setPage(new Page());

        return null;//userService.getUserList(vo);
    }

    @RequestMapping(value = "/user", produces = "application/json")
    @ResponseBody
    public Object testUserService(@RequestBody SearchVo vo, HttpSession httpSession) {
        return null; //userService.getUserList(vo);
    }

    @RequestMapping(value = "/p", produces = "application/json")
    @ResponseBody
    public Object testParams(@RequestBody SearchVo searchVo, HttpSession httpSession) throws Exception {

        ResponseResult responseResult = new ResponseResult();
        ListResultData listResultData = new ListResultData();

        try {
            // 如果有分页信息请求，那么需要返回完整的分页数据
            if (searchVo.getPage() != null) {
                Page page = new Page();
                page.setPageNO(searchVo.getPage().getPageNO());
                page.setEveryPageCount(searchVo.getPage().getEveryPageCount());
                page.setTotalCount(orderService.getOrderListTotalCount(searchVo));

                listResultData.setPage(page);
            }
            listResultData.setList(orderService.getOrderList(searchVo));


            responseResult.setData(listResultData);
            responseResult.setResult(true);
        } catch (Exception ex) {
            responseResult.setResult(false);
            responseResult.setMessage(ex.getMessage());
            ex.printStackTrace();
        }

        return responseResult;
    }

}
