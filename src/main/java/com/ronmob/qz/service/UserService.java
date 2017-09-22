package com.ronmob.qz.service;

import com.ronmob.qz.model.User;
import com.ronmob.qz.vo.SearchVo;

import java.util.List;

/**
 * 创建时间：9/20/17
 * 创建人：sunwuyang
 */
public interface UserService {
    List<User> getUserList(SearchVo searchVo);

    Integer getUserListTotalCount(SearchVo searchVo);

    User createUser(User user);

    User updateUser(User user);
}
