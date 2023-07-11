package com.ljp.service;

import com.ljp.dao.UserDao;
import com.ljp.entity.User;
import com.ljp.util.MyBatisUtils;

public interface UserService {

    void regist(User user);

    boolean checkUserName(String username);

    User login(String username, String password);
}
