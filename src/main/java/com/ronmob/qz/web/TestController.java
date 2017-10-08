package com.ronmob.qz.web;

import com.ronmob.qz.common.WxHelper;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.*;
import com.ronmob.qz.vo.SearchVo;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * 创建时间：9/21/17
 * 创建人：sunwuyang
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private static Log logger = LogFactory.getLog(TestController.class);

    @Autowired
    UserService userService;

    @Autowired
    PayOrderService payOrderService;

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
    public Object getSurveyClasses(HttpServletRequest req, HttpServletResponse response) {
        logger.info("fuck !!!!!!!!");
        User user = new User();
        user.setUserName("Jeffrey");
        user.setIsAgent((byte) 0);
        user.setBalance(new BigDecimal(20));
        user.setScore(20);
        user.setWxOpenId("lkasiuuyqkjsdfouoipuoh2yu3");
        //userService.createUser(user);

        SearchVo vo = new SearchVo();
        vo.setPage(new Page());
        Cookie ck = new Cookie("jeffrey", "hello");
        ck.setPath("/");
        System.out.println(ck.getDomain());
        response.addCookie(ck);
        return null;//userService.getUserList(vo);
    }

    @RequestMapping(value = "/user", produces = "application/json")
    @ResponseBody
    public Object testUserService(HttpServletRequest req) {
        return null; //userService.getUserList(vo);
    }

    @RequestMapping(value = "/msg", produces = "application/json")
    @ResponseBody
    public void testTemplateMessage(HttpServletRequest req) throws Exception {
        req.getHeader("");
    }


    @RequestMapping(value = "/p", produces = "application/json")
    @ResponseBody
    public Object testParams(@RequestBody SearchVo searchVo) throws Exception {

        ResponseResult responseResult = new ResponseResult();
        ListResultData listResultData = new ListResultData();

        try {
            // 如果有分页信息请求，那么需要返回完整的分页数据
            if (searchVo.getPage() != null) {
                Page page = new Page();
                page.setPageNO(searchVo.getPage().getPageNO());
                page.setEveryPageCount(searchVo.getPage().getEveryPageCount());
                page.setTotalCount(payOrderService.getOrderListTotalCount(searchVo));

                listResultData.setPage(page);
            }
            listResultData.setList(payOrderService.getOrderList(searchVo));


            responseResult.setData(listResultData);
            responseResult.setSuccess(true);
        } catch (Exception ex) {
            responseResult.setSuccess(false);
            responseResult.setMessage(ex.getMessage());
            ex.printStackTrace();
        }

        return responseResult;
    }

}
