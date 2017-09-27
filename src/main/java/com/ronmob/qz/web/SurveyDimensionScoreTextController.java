package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.SurveyDimensionScoreText;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.SurveyDimensionScoreTextService;
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
@RequestMapping("/surveyDimensionScoreText")
public class SurveyDimensionScoreTextController {

    private static Log logger = LogFactory.getLog(SurveyDimensionScoreTextController.class);

    @Autowired
    SurveyDimensionScoreTextService surveyDimensionScoreTextService;

    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveyDimensionScoreTextList(@RequestBody SearchVo searchVo) {
        ResponseResult result = new ResponseResult();
        ListResultData listResultData = new ListResultData();

        try {
            Page page = Util.getPageFromSearchVo(searchVo);
            if (page != null) {
                page.setTotalCount(surveyDimensionScoreTextService.getSurveyDimensionsScoreTextListTotalCount(searchVo));
                listResultData.setPage(page);
            }

            listResultData.setList(surveyDimensionScoreTextService.getSurveyDimensionScoreTextWithBLOBsList(searchVo));

            result.setData(listResultData);
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }
        return result;
    }


    @RequestMapping(value = "/get", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveysDimensionScoreText(Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            result.setSuccess(true);
            result.setData(this.surveyDimensionScoreTextService.getSurveyDimensionScoreText(id));
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public ResponseResult insertSurveysDimensionScoreText(HttpSession httpSession, @RequestBody SurveyDimensionScoreText surveyDimensionScoreText) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyDimensionScoreTextService.createSurveyDimensionScoreText(surveyDimensionScoreText);
            result.setSuccess(true);
            result.setData(surveyDimensionScoreText);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseResult updateSurveysDimensionScoreText(HttpSession httpSession, @RequestBody SurveyDimensionScoreText surveyDimensionScoreText) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyDimensionScoreTextService.updateSurveyDimensionScoreText(surveyDimensionScoreText);
            result.setSuccess(true);
            result.setData(surveyDimensionScoreText);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/delete", produces = "application/json")
    @ResponseBody
    public ResponseResult deleteSurveysDimensionScoreText(HttpSession httpSession, Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            if (id == null) {
                throw new Exception("id参数为空");
            }
            surveyDimensionScoreTextService.deleteSurveyDimensionScoreTextById(id);
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

}