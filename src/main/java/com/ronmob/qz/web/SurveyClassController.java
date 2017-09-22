package com.ronmob.qz.web;

import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.SurveyClassService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/surveyClass")
public class SurveyClassController {

    private static Log logger = LogFactory.getLog(SurveyClassController.class);

    @Autowired
    SurveyClassService surveyClassService;

    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveyClasses(Byte enabled) {
        ResponseResult result = new ResponseResult();
        try {
            result.setData(surveyClassService.getSurveyClassList(enabled));
            result.setResult(true);
        } catch (Exception ex) {
            result.setResult(false);
            result.setMessage(ex.getMessage());

            logger.error(ex);
        }
        return result;
    }

}