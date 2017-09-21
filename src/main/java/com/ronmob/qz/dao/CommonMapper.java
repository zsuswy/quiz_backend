package com.ronmob.qz.dao;

import java.util.List;

import com.ronmob.qz.model.SurveyClass;

public interface CommonMapper {
	List<SurveyClass> getSurveyClasses(Integer enabled);
}