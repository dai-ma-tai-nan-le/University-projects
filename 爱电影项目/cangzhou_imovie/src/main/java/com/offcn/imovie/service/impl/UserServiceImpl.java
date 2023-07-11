package com.offcn.imovie.service.impl;

import com.offcn.imovie.dao.UserDao;
import com.offcn.imovie.pojo.User;
import com.offcn.imovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//实现类必须添加的注解 @Service
@Service
public class UserServiceImpl implements UserService {


    // 声明dao对象，=== 注入
    @Autowired
    UserDao userDao;

    public List<User> getUserList() {
        List<User> userlist = userDao.getUserlist();
        return userlist;
    }

    public void saveRegister(String username, String password) {
        userDao.saveRegister(username,password);
    }

    public boolean checkLogin(String username, String password) {
        List<User> list = userDao.findByUsernameAndPassword(username,password);
        return (list!=null&&list.size()>0)?true:false;
    }

}
