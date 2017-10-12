package com.ronmob.qz.service.impl;

import java.util.List;

import com.ronmob.qz.dao.SurveyClassMapper;
import com.ronmob.qz.model.SurveyClass;
import com.ronmob.qz.model.SurveyClassExample;
import com.ronmob.qz.service.SurveyClassService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyClassServiceImpl implements SurveyClassService {
    private static Log logger = LogFactory.getLog(SurveyClassServiceImpl.class);

    @Autowired
    private SurveyClassMapper classMapper;

    @Override
    public List<SurveyClass> getSurveyClassList(Byte enabled) {
        SurveyClassExample example = new SurveyClassExample();

        if (enabled != null) {
            example.createCriteria().andEnabledEqualTo(enabled);
        }

        return classMapper.selectByExample(example);
    }
}
