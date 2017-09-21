package com.ronmob.qz.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.service.CommonService;

@Controller
@RequestMapping("/common")
public class CommonController {
	@Autowired
	CommonService commonService;

	@RequestMapping(value = "/getSurveyClasses", produces = "application/json")
	@ResponseBody
	public List<SurveyClass> getSurveyClasses(HttpSession httpSession, Integer enabled) {
		return commonService.getSurveyClassList(enabled);
	}
}
