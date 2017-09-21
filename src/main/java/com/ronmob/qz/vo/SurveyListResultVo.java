package com.ronmob.qz.vo;

import java.util.List;

import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.Survey;

public class SurveyListResultVo {
	private Page page;
	private List<Survey> surveyList;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Survey> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(List<Survey> surveyList) {
		this.surveyList = surveyList;
	}

}