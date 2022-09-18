package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.dao.impl.UserDaoImpl;
import com.offcn.entity.User;
import com.offcn.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl() ;
    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        return userDao.selectByUsernameAndPassword(username, password);
        }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
};


