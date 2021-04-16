package com.csw.dao;


import com.csw.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by HIAPAD on 2019/10/21.
 */
public interface UserDao {

    User queryUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    void add(@Param("user") User user);
}
