package com.ronmob.qz.vo;

import java.util.List;

import com.ronmob.qz.model.common.Page;
import com.ronmob.qz.model.Survey;

public class SurveyListResultVo {
	Page page;
	List<Survey> surveys;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

}