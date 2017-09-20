package com.ronmob.qz.vo;

import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.SurveyQuestion;

public class SurveyQuestionListSearchVo {
	Page page;
	SurveyQuestion surveyQuestion;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public SurveyQuestion getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}
}