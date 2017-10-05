package com.ronmob.qz.service.impl;

import com.ronmob.qz.common.Util;
import com.ronmob.qz.dao.UserMapper;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.UserExample;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    private UserExample getUserExample(SearchVo searchVo) {
        UserExample example = new UserExample();
        if (searchVo.getPage() != null) {
            example.setLimit(searchVo.getPage().getLimit());
            example.setOffset(searchVo.getPage().getOffset());
        }

        Map params = searchVo.getParams();
        UserExample.Criteria criteria = example.createCriteria();

        if (params.containsKey("id")) {
            criteria.andIdEqualTo(Util.getInteger(params.get("id").toString()));
        }
        if (params.containsKey("isAgent")) {
            criteria.andIsAgentEqualTo(Util.getByte(params.get("isAgent").toString()));
        }

        return example;
    }

    @Override
    public List<User> getUserList(SearchVo searchVo) {
        UserExample example = getUserExample(searchVo);
        return userMapper.selectByExample(example);
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer getUserListTotalCount(SearchVo searchVo) {
        UserExample example = getUserExample(searchVo);

        return ((Long) userMapper.countByExample(example)).intValue();
    }

    @Override
    public User createUser(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
        return user;
    }
}
