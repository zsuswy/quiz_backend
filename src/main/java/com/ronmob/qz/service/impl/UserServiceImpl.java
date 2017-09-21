package com.ronmob.qz.service.impl;

import com.ronmob.qz.dao.UserMapper;
import com.ronmob.qz.model.User;
import com.ronmob.qz.service.UserService;
import com.ronmob.qz.vo.UserListSearchVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList(UserListSearchVo userListSearchVo) {
        return userMapper.getUserList(userListSearchVo);
    }

    @Override
    public Integer getUserListTotalCount(UserListSearchVo userListSearchVo) {
        return userMapper.getUserListTotalCount(userListSearchVo);
    }

    @Override
    public User createUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return user;
    }
}
