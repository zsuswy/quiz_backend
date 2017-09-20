package com.ronmob.qz.vo;

import java.util.List;

import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.SurveyQuestion;

public class SurveyQuestionListResultVo {
	Page page;
	List<SurveyQuestion> surveyQuestions;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<SurveyQuestion> getSurveyQuestions() {
		return surveyQuestions;
	}

	public void setSurveyQuestions(List<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}
}