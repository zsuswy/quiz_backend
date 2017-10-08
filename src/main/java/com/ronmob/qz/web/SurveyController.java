package com.ronmob.qz.web;

import javax.servlet.http.HttpSession;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.SurveyService;
import com.ronmob.qz.model.common.Page;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    private static Log logger = LogFactory.getLog(SurveyController.class);

    @Autowired
    private SurveyService surveyService;

    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveys(@RequestBody SearchVo searchVo) {
        ResponseResult result = new ResponseResult();
        ListResultData listResultData = new ListResultData();
        try {
            Page page = Util.getPageFromSearchVo(searchVo);
            if (page != null) {
                page.setTotalCount(surveyService.getSurveyListTotalCount(searchVo));
                listResultData.setPage(page);
            }

            listResultData.setList(this.surveyService.getSurveyWithBOLBsList(searchVo));

            result.setSuccess(true);
            result.setData(listResultData);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
            ex.printStackTrace();
            logger.error(ex);
        }

        return result;
    }


    @RequestMapping(value = "/get", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurvey(Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            Survey survey = this.surveyService.getSurvey(id);
            result.setSuccess(true);
            result.setData(survey);

        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public ResponseResult insertSurvey(@RequestBody Survey vo) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyService.createSurvey(vo);
            result.setSuccess(true);
            result.setData(vo);

        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseResult updateSurvey(@RequestBody Survey vo) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyService.updateSurvey(vo);
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

}