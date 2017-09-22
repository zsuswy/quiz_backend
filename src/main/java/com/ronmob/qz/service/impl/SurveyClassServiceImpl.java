package com.ronmob.qz.service.impl;

import java.util.List;

import com.ronmob.qz.dao.SurveyClassMapper;
import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.model.SurveyClassExample;
import com.ronmob.qz.service.SurveyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyClassServiceImpl implements SurveyClassService {
    @Autowired
    private SurveyClassMapper classMapper;

    @Override
    public List<SurveyClass> getSurveyClassList(Byte enabled) {
        SurveyClassExample example = new SurveyClassExample();
        example.createCriteria().andEnabledEqualTo(enabled);
        return classMapper.selectByExample(example);
    }
}