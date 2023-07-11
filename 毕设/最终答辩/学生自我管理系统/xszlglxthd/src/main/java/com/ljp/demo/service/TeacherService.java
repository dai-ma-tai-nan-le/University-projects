package com.ljp.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 教师(Teacher)表服务接口
 *
 * @author makejava
 * @since 2023-03-16 20:20:29
 */
public interface TeacherService {

    //分页查询教师数的
    IPage<Teacher> findByAllPage(Page<Teacher> page);
    //分页模糊查询教师人数的
    List<Teacher> selectList(Page<Teacher> page, @Param("username") String username);
    //分页模糊查询教师姓名的
    List<Teacher> selectList1(Page<Teacher> page, @Param("teaname") String teaname);
    //分页模糊查询教师姓名的
    List<Teacher> selectList2(Page<Teacher> page, @Param("username") String username, @Param("teaname") String teaname);
    ///查重名教师
    List<User> findUserByUsername(@Param("username") String username);

    //添加教师
    void adduname(User user);
    void addtea(Teacher teacher);
    //删除教师
    void deltea(@Param("username") String username);
    void deltea1(@Param("username") String username);
    //查询教师人数的
    List<Teacher> selectteaList(@Param("username") String username);
    //修改教师
    void modtea(User user);
    void modtea1(Teacher teacher);

    ///查重名教师id
    List<Teacher> findUserTeanumber(@Param("teanumber") int teanumber);



    //教师查询数量
    Long selectnum1(@Param("username") String username, @Param("teaname") String teaname);
    Long selectnum2(@Param("username") String username);
    Long selectnum3(@Param("teaname") String teaname);
}
