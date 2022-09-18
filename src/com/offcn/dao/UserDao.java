package com.offcn.dao;

import com.offcn.entity.User;

public interface UserDao {
    //根据用户名与密码来进行查询
    User selectByUsernameAndPassword(String username, String password);
    int addUser(User user);
}