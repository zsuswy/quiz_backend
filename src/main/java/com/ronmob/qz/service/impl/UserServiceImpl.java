package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.UserMapper;
import com.ronmob.qz.model.User;
import com.ronmob.qz.model.UserExample;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.vo.UserListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    private UserExample getUserExample(UserListSearchVo vo) {
        UserExample example = new UserExample();
        return example;
    }

    @Override
    public List<User> getUserList(UserListSearchVo userListSearchVo) {
        UserExample example = getUserExample(userListSearchVo);
        return userMapper.selectByExample(example);
    }

    @Override
    public Integer getUserListTotalCount(UserListSearchVo userListSearchVo) {
        UserExample example = getUserExample(userListSearchVo);

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
