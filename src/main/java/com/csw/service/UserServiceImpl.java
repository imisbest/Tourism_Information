package com.csw.service;

import com.csw.dao.UserDao;
import com.csw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019/10/22.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User findUsernameAndPassword(String username, String password) {

        return userDao.queryUsernameAndPassword(username, password);
    }

    @Override
    public void add(User user2) {
        userDao.add(user2);
    }

}
