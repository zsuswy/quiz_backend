package com.ronmob.qz.vo;

import java.util.List;

import com.ronmob.qz.model.SurveyQuestion;
import com.ronmob.qz.model.common.Page;

public class SurveyQuestionListResultVo {
	private Page page;
	private List<SurveyQuestion> surveyQuestionList;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<SurveyQuestion> getSurveyQuestionList() {
		return surveyQuestionList;
	}

	public void setSurveyQuestionList(List<SurveyQuestion> surveyQuestionList) {
		this.surveyQuestionList = surveyQuestionList;
	}
}