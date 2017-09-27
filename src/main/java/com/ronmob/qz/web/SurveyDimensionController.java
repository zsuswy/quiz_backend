package com.ronmob.qz.web;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.model.SurveyDimension;
import com.ronmob.qz.model.common.ListResultData;
import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.SurveyDimensionService;
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
@RequestMapping("/surveyDimension")
public class SurveyDimensionController {

    private static Log logger = LogFactory.getLog(SurveyDimensionController.class);

    @Autowired
    SurveyDimensionService surveyDimensionService;

    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveyDimensionList(@RequestBody SearchVo searchVo) {
        ResponseResult result = new ResponseResult();
        ListResultData listResultData = new ListResultData();

        try {
            Page page = Util.getPageFromSearchVo(searchVo);
            if (page != null) {
                page.setTotalCount(surveyDimensionService.getSurveyDimensionListTotalCount(searchVo));
                listResultData.setPage(page);
            }

            listResultData.setList(surveyDimensionService.getSurveyDimensionList(searchVo));

            result.setData(listResultData);
            result.setSuccess(true);
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
    public ResponseResult getSurveysDimension(Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            result.setSuccess(true);
            result.setData(this.surveyDimensionService.getSurveyDimension(id));
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public ResponseResult insertSurveysDimension(HttpSession httpSession, @RequestBody SurveyDimension surveyDimension) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyDimensionService.createSurveyDimension(surveyDimension);
            result.setSuccess(true);
            result.setData(surveyDimension);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public ResponseResult updateSurveysDimension(HttpSession httpSession, @RequestBody SurveyDimension surveyDimension) {
        ResponseResult result = new ResponseResult();
        try {
            this.surveyDimensionService.updateSurveyDimension(surveyDimension);
            result.setSuccess(true);
            result.setData(surveyDimension);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

    @RequestMapping(value = "/delete", produces = "application/json")
    @ResponseBody
    public ResponseResult deleteSurveysDimension(HttpSession httpSession, Integer id) {
        ResponseResult result = new ResponseResult();
        try {
            if (id == null) {
                throw new Exception("id参数为空");
            }
            surveyDimensionService.deleteSurveyDimension(id);
            result.setSuccess(true);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }

        return result;
    }

}