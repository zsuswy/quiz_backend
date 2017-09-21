package com.ronmob.qz.dao;

import com.ronmob.qz.model.User;
import com.ronmob.qz.vo.UserListSearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface UserMapper {
    List<User> getUserList(UserListSearchVo vo);

    Integer getUserListTotalCount(UserListSearchVo vo);

    Integer InsertUser(User user);

    Integer UpdateUser(User user);
}
