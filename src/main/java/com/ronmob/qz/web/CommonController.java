package com.ronmob.qz.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.SurveyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/common")
public class CommonController {
    @Autowired
    SurveyClassService surveyClassService;

    @RequestMapping(value = "/getSurveyClasses", produces = "application/json")
    @ResponseBody
    public ResponseResult getSurveyClasses(HttpSession httpSession, Byte enabled) {
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
