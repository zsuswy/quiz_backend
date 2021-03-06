package com.ronmob.qz.web;

import com.alibaba.fastjson.JSON;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.*;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @Value("${img_url_path}")
    private String img_url_path;

    @Autowired
    WxHelper wxHelper;

    @RequestMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public Object getSurveyClasses(HttpServletRequest req, HttpServletResponse response) {
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

            logger.error(ex);
        }

        return responseResult;
    }

}
