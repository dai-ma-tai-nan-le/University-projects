package com.ljp.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljp.demo.entity.Student;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * 用户账户：用于保存用户登录信息(User)表服务接口
 *
 * @author makejava
 * @since 2023-03-10 13:25:27
 */
public interface UserService extends IService<User> {

    List<User> queryByUsername(String username);
    //查询管理员人数的
    List<User> selectGlyList(@Param("username") String username);
    //查询总条数
    Long allTotal();
    //分页查询管理员人数的
    IPage<User> findByAllPage(Page<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);
    //分页模糊查询管理员人数的
    List<User> selectList(Page<User> page,@Param("username") String username);
    ///查重名管理员
    List<User> findUserByUsername(@Param("username") String username);

    //添加管理员
    void addgly(User user);
    //删除管理员
    void delgly(@Param("username") String username);
    //修改管理员
    void modgly(User user);

    //登录查询学生信息的
    List<Student> selectstuList(@Param("username")String username);
    //登录查询教师信息的
    List<Teacher> selectteaList(@Param("username")String username);
    //更新登录时间的
    void modlogintime(Date loginTime,@Param("username")String username);
    //修改密码
    void updatePassword(User user);


    //教师查询长度
    Long selectnum1(@Param("username")String username);
}
