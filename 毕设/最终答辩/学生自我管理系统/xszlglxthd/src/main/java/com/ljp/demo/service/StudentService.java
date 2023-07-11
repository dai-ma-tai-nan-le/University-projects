package com.ljp.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Student;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 学生(Student)表服务接口
 *
 * @author makejava
 * @since 2023-03-17 22:11:20
 */
public interface StudentService {

    //分页查询学生数的
    IPage<Student> findByAllPage(Page<Student> page);
    //分页模糊查询学生人数的
    List<Student> selectList(Page<Student> page, @Param("username") String username);
    //分页模糊查询学生姓名的
    List<Student> selectList1(Page<Student> page, @Param("stuname") String stuname);
    //分页模糊查询学生姓名的
    List<Student> selectList2(Page<Student> page, @Param("username") String username, @Param("stuname") String stuname);
    ///查重名学生
    List<User> findUserByUsername(@Param("username") String username);
    ///查重名学生id
    List<Student> findUserStunumber(@Param("stunumber") int stunumber);

    //添加学生
    void adduname(User user);
    void addstu(Student student);
    List<Teacher> findUserTeanumber2(@Param("academy") String academy);
    //删除学生
    void delstu(@Param("username") String username);
    void delstu1(@Param("username") String username);
    //查询学生人数的
    List<Student> selectstuList(@Param("username") String username);
    //修改学生
    void modstu(User user);
    void modstu1(Student student);
    //查教师id学院与学生学院是否一样
    List<Student> findUserTeanumber(@Param("username") String username);
    List<Teacher> findUserTeanumber1(@Param("teaNumber") int teaNumber);

    
//    教师查询长度
    Long selectnum1(@Param("username") String username, @Param("stuname") String stuname);
    Long selectnum2(@Param("username") String username);
    Long selectnum3(@Param("stuname") String stuname);



    //分页查询学生数的
    IPage<Student> findByAllPage1(Page<Student> page,@Param("academy") String academy);
    //分页模糊查询学生人数的
    List<Student> selectList4(Page<Student> page, @Param("username") String username,@Param("academy") String academy);
    //分页模糊查询学生姓名的
    List<Student> selectList5(Page<Student> page, @Param("stuname") String stuname,@Param("academy") String academy);
    //分页模糊查询学生姓名的
    List<Student> selectList3(Page<Student> page, @Param("username") String username, @Param("stuname") String stuname,@Param("academy") String academy);
    //教师查询长度
    Long selectnum4(@Param("username") String username, @Param("stuname") String stuname,@Param("academy") String academy);
    Long selectnum5(@Param("username") String username,@Param("academy") String academy);
    Long selectnum6(@Param("stuname") String stuname,@Param("academy") String academy);
}
