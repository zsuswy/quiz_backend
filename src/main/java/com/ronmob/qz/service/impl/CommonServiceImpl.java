package com.ronmob.qz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronmob.qz.dao.CommonMapper;
import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService{
    @Autowired
    private CommonMapper commonMapper;

	@Override
	public List<SurveyClass> getSurveyClasses(int enabled) {
		// TODO Auto-generated method stub
		return commonMapper.getSurveyClasses(enabled);
	}

}
