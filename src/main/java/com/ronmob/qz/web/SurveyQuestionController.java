package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.SurveyQuestionService;
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
@RequestMapping("/surveyQuestion")
public class SurveyQuestionController {

    private static Log logger = LogFactory.getLog(SurveyQuestionController.class);

    @Autowired
    private SurveyQuestionService surveyQuestionService;


    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveyQuestionList(HttpSession httpSession, @RequestBody SearchVo searchVo) {
        ResponseResult result = new ResponseResult();
        ListResultData listResultData = new ListResultData();

        try {
            Page page = Util.getPageFromSearchVo(searchVo);
            if (page != null) {
                page.setTotalCount(surveyQuestionService.getSurveyQuestionListTotalCount(searchVo));
                listResultData.setPage(page);
            }

            listResultData.setList(surveyQuestionService.getSurveyQuestionList(searchVo));
            result.setResult(true);
            result.setData(listResultData);
        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }
        return result;
    }

    @RequestMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public ResponseResult insertSurveyQuestion(HttpSession httpSession, @RequestBody SurveyQuestion surveyQuestion) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyQuestionService.createSurveyQuestion(surveyQuestion);
            result.setResult(true);
            result.setData(surveyQuestion);
        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseResult updateSurveyQuestion(HttpSession httpSession, @RequestBody SurveyQuestion surveyQuestion) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyQuestionService.updateSurveyQuestion(surveyQuestion);
            result.setResult(true);
            result.setData(surveyQuestion);
        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/delete", produces = "application/json")
    @ResponseBody
    public ResponseResult deleteSurveyQuestion(HttpSession httpSession, Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            if (id == null) {
                throw new Exception("id参数为空");
            }

            surveyQuestionService.deleteSurveyQuestionById(id);

            result.setResult(true);
        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }
}