package com.ronmob.qz.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.service.SurveyClassService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/common")
public class CommonController {
    private static Log logger = LogFactory.getLog(CommonController.class);

    @Autowired
    SurveyClassService surveyClassService;
}
