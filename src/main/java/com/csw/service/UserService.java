package com.csw.service;

import com.csw.entity.User;

/**
 * Created by Administrator on 2019/10/22.
 */
public interface UserService {
    User findUsernameAndPassword(String username, String password);

    void add(User user2);
}
