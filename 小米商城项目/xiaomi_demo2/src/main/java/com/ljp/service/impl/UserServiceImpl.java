package com.ljp.service.impl;

import com.ljp.dao.UserDao;
import com.ljp.entity.User;
import com.ljp.service.UserService;
import com.ljp.util.EmailUtils;
import com.ljp.util.Md5Utils;
import com.ljp.util.MyBatisUtils;

public class UserServiceImpl implements UserService {
    UserDao userDao= MyBatisUtils.getMapper(UserDao.class);
    //注册
    public void regist(User user) {
        //密码加密:SALT
        user.setUpassword(Md5Utils.md5("xiaomi"+user.getUpassword()+"xiaomi"));
        //判断用户名是否可用
        User u=userDao.selectByUsername(user.getUname());
        if(u!=null){
            throw new RuntimeException("用户名已存在");
        }
        userDao.insertUser(user);
//        System.out.println(user);
        MyBatisUtils.commit();

        //发送邮件
        EmailUtils.sendEmail(user);
    }
    //重名检查
    public boolean checkUserName(String username) {
//        System.out.println("username="+username);
        User user=userDao.selectByUsername(username);
        System.out.println("user="+user);
        if(user!=null){
            return true;
        }
        return false;
    }

    //登录
    @Override
    public User login(String username, String password) {
        password=Md5Utils.md5(password);
        User user=userDao.selectByUsernameAndPassword(username,password);
//        System.out.println("user1="+user);
        if (user==null){
            throw new RuntimeException("用户名或密码错误");
        }
        if(!user.getUstatus().equals("1")){
            throw new RuntimeException("账号未激活或异常");
        }
        return user;
    }
}
