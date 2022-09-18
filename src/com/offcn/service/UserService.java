package com.offcn.service;

import com.offcn.entity.User;

public interface UserService {
    User selectByUsernameAndPassword(String username, String password);

    int addUser(User user);
}

