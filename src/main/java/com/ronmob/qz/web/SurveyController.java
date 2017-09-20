package com.ronmob.qz.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ronmob.qz.service.SurveyQuestionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ronmob.qz.model.common.ResponseResult;
import com.ronmob.qz.model.Survey;
import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.service.CommonService;
import com.ronmob.qz.service.SurveyService;
import com.ronmob.qz.vo.SurveyListResultVo;
import com.ronmob.qz.vo.SurveyListSearchVo;
import com.ronmob.qz.vo.SurveyQuestionListResultVo;
import com.ronmob.qz.vo.SurveyQuestionListSearchVo;
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
	CommonService commonService;

	@RequestMapping(value = "/getSurveys", produces = "application/json")
	@ResponseBody
	public SurveyListResultVo getSurveys(HttpSession httpSession, @RequestBody SurveyListSearchVo vo) {
		SurveyListResultVo result = new SurveyListResultVo();
		Page page = vo.getPage();
		if (page == null) {
			page = new Page();
		}
		result.setSurveys(this.surveyService.getSurveys(vo));
		page.setTotalCount(surveyService.getSurveysCount(vo).intValue());
		result.setPage(page);

		return result;
	}

	@RequestMapping(value = "/getSurveyQuestions", produces = "application/json")
	@ResponseBody
	public SurveyQuestionListResultVo getSurveyQuestions(HttpSession httpSession,
			@RequestBody SurveyQuestionListSearchVo vo) {
		SurveyQuestionListResultVo result = new SurveyQuestionListResultVo();
		Page page = vo.getPage();
		if (page == null) {
			page = new Page();
		}
		result.setSurveyQuestions(this.surveyQuestionService.getSurveyQuestions(vo));
		page.setTotalCount(this.surveyQuestionService.getSurveyQuestionsCount(vo));
		result.setPage(page);

		return result;
	}

	@RequestMapping(value = "/insertSurvey", produces = "application/json")
	@ResponseBody
	public ResponseResult insertSurveys(HttpSession httpSession, @RequestBody Survey vo) {
		ResponseResult result = new ResponseResult();
		try {
			this.surveyService.insertSurvey(vo);
			result.setResult("success");
			result.setData(vo);

		} catch (Exception ex) {
			result.setResult("fail");
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
			result.setResult("success");
		} catch (Exception ex) {
			result.setResult("fail");
			result.setMessage(ex.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "/insertSurveyQuestion", produces = "application/json")
	@ResponseBody
	public ResponseResult insertSurveysQuestion(HttpSession httpSession, @RequestBody SurveyQuestion vo) {
		ResponseResult result = new ResponseResult();
		try {
			this.surveyQuestionService.insertSurveyQuestion(vo);
			result.setResult("success");
			result.setData(vo);
		} catch (Exception ex) {
			result.setResult("fail");
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
			result.setResult("success");
			result.setData(vo);
		} catch (Exception ex) {
			System.out.println(ex);
			result.setResult("fail");
			result.setMessage(ex.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "/getSurveyClasses", produces = "application/json")
	@ResponseBody
	public List<SurveyClass> getSurveyClasses(HttpSession httpSession,
			@RequestParam(value = "enabled") int enabled) {
		System.out.println(enabled);
		return commonService.getSurveyClasses(enabled);
	}

}