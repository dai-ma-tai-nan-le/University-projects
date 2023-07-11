package com.ljp.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljp.demo.entity.Student;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import com.ljp.demo.dao.UserDao;
import com.ljp.demo.service.UserService;
import com.ljp.demo.utils.Md5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户账户：用于保存用户登录信息(User)表服务实现类
 *
 * @author makejava
 * @since 2023-03-10 13:25:27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> queryByUsername(String username) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(username),"username",username);
        List<User> list=this.userDao.selectList(wrapper);
        return null;
    }

    //查询管理员人数的
    @Override
    public List<User> selectGlyList(@Param("username") String username) {
        return userDao.selectGlyList(username);
    }

    //查询总条数
    @Override
    public Long allTotal() {
        return userDao.allTotal();
    }

    //分页查询管理员人数的
    @Override
    public IPage<User> findByAllPage(Page<User> page,@Param(Constants.WRAPPER) Wrapper wrapper) {
        return userDao.findByAllPage(page,wrapper);
    }

    ////分页模糊查询管理员人数的
    @Override
    public List<User> selectList(Page<User> page, @Param("username") String username) {
        return userDao.selectList(page,username);
    }

    ///查重名管理员
    @Override
    public List<User> findUserByUsername(@Param("username") String username) {
        return userDao.findUserByUsername(username);
    }

    //添加管理员
    @Override
    public void addgly(User user) {
        // 密码加密Salt
        user.setPassword(Md5Utils.md5(user.getPassword()));
        userDao.addgly(user);
    }

    //删除管理员
    @Override
    public void delgly(@Param("username") String username) {
        userDao.delgly(username);
    }

    //修改管理员
    @Override
    public void modgly(User user) {
        userDao.modgly(user);
    }

    //登录查询学生信息的
    @Override
    public List<Student> selectstuList(@Param("username") String username) {
        return userDao.selectstuList(username);
    }
    //登录查询教师信息的
    @Override
    public List<Teacher> selectteaList(@Param("username")String username) {
        return userDao.selectteaList(username);
    }
    //更新登录时间的
    @Override
    public void modlogintime(Date loginTime,@Param("username")String username) {
        userDao.modlogintime(loginTime,username);
    }
    //修改密码
    @Override
    public void updatePassword(User user) {
        // 密码加密Salt
        user.setPassword(Md5Utils.md5(user.getPassword()));
        userDao.updatePassword(user);
    }


    //教师查询长度
    @Override
    public Long selectnum1(@Param("username")String username) {
        return userDao.selectnum1(username);
    }


}
