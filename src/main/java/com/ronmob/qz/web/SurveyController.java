package com.ronmob.qz.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.service.SurveyClassService;
import com.ronmob.qz.service.SurveyQuestionService;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.vo.SearchVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private SurveyQuestionService surveyQuestionService;


    @Autowired
    SurveyClassService surveyClassService;

    @RequestMapping(value = "/getSurveys", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveys(HttpSession httpSession, @RequestBody SearchVo searchVo) {
        ResponseResult result = new ResponseResult();
        ListResultData listResultData = new ListResultData();
        try {
            Page page = Util.getPageFromSearchVo(searchVo);
            if (page != null) {
                page.setTotalCount(surveyService.getSurveyListTotalCount(searchVo));
                listResultData.setPage(page);
            }

            listResultData.setList(this.surveyService.getSurveyList(searchVo));

            result.setResult(true);
            result.setData(listResultData);
        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());
            ex.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = "/getSurveyQuestions", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveyQuestions(HttpSession httpSession, @RequestBody SearchVo searchVo) {
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
            ex.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/insertSurvey", produces = "application/json")
    @ResponseBody
    public ResponseResult insertSurveys(HttpSession httpSession, @RequestBody Survey vo) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyService.createSurvey(vo);
            result.setResult(true);
            result.setData(vo);

        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/updateSurvey", produces = "application/json")
    @ResponseBody
    public ResponseResult updateSurvey(HttpSession httpSession, @RequestBody Survey vo) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyService.updateSurvey(vo);
            result.setResult(true);
        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/insertSurveyQuestion", produces = "application/json")
    @ResponseBody
    public ResponseResult insertSurveysQuestion(HttpSession httpSession, @RequestBody SurveyQuestion vo) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyQuestionService.createSurveyQuestion(vo);
            result.setResult(true);
            result.setData(vo);
        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/updateSurveyQuestion", produces = "application/json")
    @ResponseBody
    public ResponseResult updateSurveysQuestion(HttpSession httpSession, @RequestBody SurveyQuestion vo) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyQuestionService.updateSurveyQuestion(vo);
            result.setResult(true);
            result.setData(vo);
        } catch (Exception ex) {
            System.out.println(ex);
            result.setResult(false);
            result.setMessage(ex.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/getSurveyClasses", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveyClasses(Byte enabled) {
        ResponseResult result = new ResponseResult();
        try {
            result.setData(surveyClassService.getSurveyClassList(enabled));
            result.setResult(true);
        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());
        }
        return result;
    }

}