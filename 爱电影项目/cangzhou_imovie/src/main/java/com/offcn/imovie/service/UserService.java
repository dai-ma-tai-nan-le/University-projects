package com.offcn.imovie.service;

import com.offcn.imovie.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 查询用户列表
     * @return
     */
    public List<User> getUserList();

    /**
     * 用户注册
     * @Param username
     * @Param password
     */
    void saveRegister(String username,String password);

    /**
     *登录校验
     * @Param username
     * @Param password
     * @return
     */
    boolean checkLogin(String username, String password);
}
