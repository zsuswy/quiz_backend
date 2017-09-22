package com.ronmob.qz.service;

import com.ronmob.qz.model.SurveyClass;

import java.util.List;

public interface SurveyClassService {
    List<SurveyClass> getSurveyClassList(Byte enabled) throws Exception;
}
