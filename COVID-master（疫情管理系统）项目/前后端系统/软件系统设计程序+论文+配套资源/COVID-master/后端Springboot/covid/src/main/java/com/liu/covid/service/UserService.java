package com.liu.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.covid.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends IService<User> {
    public String login(User user);
    public String register(User user);
}
