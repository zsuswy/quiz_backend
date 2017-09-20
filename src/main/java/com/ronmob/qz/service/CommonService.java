package com.ronmob.qz.service;

import java.util.List;

import com.ronmob.qz.model.SurveyClass;

public interface CommonService {
    List<SurveyClass> getSurveyClasses(int enabled);
}
