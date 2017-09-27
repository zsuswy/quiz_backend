package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.Order;
import com.ronmob.qz.model.UserSurvey;
import com.ronmob.qz.model.UserSurveyWithBLOBs;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.OrderService;
import com.ronmob.qz.service.UserSurveyService;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userSurvey")
public class UserSurveyController {

    private static Log logger = LogFactory.getLog(UserSurveyController.class);

    @Autowired
    private UserSurveyService userSurveyService;


    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getUserSurveyList(HttpSession httpSession, @RequestBody SearchVo searchVo) {
        ResponseResult result = new ResponseResult();
        ListResultData listResultData = new ListResultData();

        try {
            Page page = Util.getPageFromSearchVo(searchVo);
            if (page != null) {
                page.setTotalCount(userSurveyService.getUserSurveyListTotalCount(searchVo));
                listResultData.setPage(page);
            }

            listResultData.setList(userSurveyService.getUserSurveyList(searchVo));
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
    public ResponseResult getUserSurvey(Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            result.setSuccess(true);
            result.setData(this.userSurveyService.getUserSurvey(id));
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public ResponseResult insertUserSurvey(HttpSession httpSession, @RequestBody UserSurveyWithBLOBs userSurvey) {
        ResponseResult result = new ResponseResult();
        try {
            this.userSurveyService.createUserSurvey(userSurvey);
            result.setSuccess(true);
            result.setData(userSurvey);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseResult updateUserSurvey(HttpSession httpSession, @RequestBody UserSurveyWithBLOBs userSurvey) {
        ResponseResult result = new ResponseResult();
        try {
            this.userSurveyService.updateUserSurvey(userSurvey);
            result.setSuccess(true);
            result.setData(userSurvey);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }
}