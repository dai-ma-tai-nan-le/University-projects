package com.ljp.demo.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Student;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 学生(Student)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-17 22:11:20
 */
@Mapper
public interface StudentDao {

    ////分页查询学生人数的
    @Select("select * from user as u,student as s where user_group='学生' and u.username=s.username order by stu_id desc")
    IPage<Student> findByAllPage(Page<Student> page);
    ////分页模糊查询学生人数的
    @Select("select * from user as u,student as s where user_group='学生' and u.username like CONCAT('%',#{username},'%') and u.username=s.username")
    List<Student> selectList(Page<Student> page, @Param("username") String username);
    ////分页模糊查询学生姓名的
    @Select("select * from user as u,student as s where user_group='学生' and stu_name like CONCAT('%',#{stuname},'%') and u.username=s.username")
    List<Student> selectList1(Page<Student> page, @Param("stuname") String stuname);
    ////分页模糊查询学生姓名的
    @Select("select * from user as u,student as s where user_group='学生' and u.username like CONCAT('%',#{username},'%') and stu_name like CONCAT('%',#{stuname},'%') and u.username=s.username")
    List<Student> selectList2(Page<Student> page,@Param("username") String username, @Param("stuname") String stuname);
    ///查学生重名
    @Select("select * from user where username=#{username}")
    List<User> findUserByUsername(@Param("username") String username);
    ///查重名学生id
    @Select("select * from student where stu_number=#{stunumber}")
    List<Student> findUserStunumber(@Param("stunumber") int stunumber);

    //添加学生
    @Insert("insert into user values(null,#{userGroup},#{loginTime},#{phone},#{username},#{password},#{status},#{email},#{avatar},#{createTime})")
    void adduname(User user);
    @Insert("insert into student values(null,#{stuNumber},#{stuName},#{gender},#{academy},#{major},#{className},#{teaNumber},#{username},#{createTime},#{updateTime})")
    void addstu(Student student);
    @Select("select * from teacher where faculties=#{academy}")
    List<Teacher> findUserTeanumber2(@Param("academy") String academy);
    //删除学生
    @Delete("delete from user where username=#{username}")
    void delstu(@Param("username") String username);
    @Delete("delete from student where username=#{username}")
    void delstu1(@Param("username") String username);
    //修改学生
    @Update("update user set user_group=#{userGroup},phone=#{phone},status=#{status},email=#{email} where username=#{username}")
    void modstu(User user);
    @Update("update student set stu_number=#{stuNumber},stu_name=#{stuName},gender=#{gender},academy=#{academy},major=#{major},class_name=#{className},tea_number=#{teaNumber} where username=#{username}")
    void modstu1(Student student);
    ////查询学生
    @Select("select * from user as u,student as s where user_group='学生' and u.username=#{username} and u.username=s.username")
    List<Student> selectstuList(@Param("username") String username);

    //查教师id学院与学生学院是否一样
    @Select("select * from student where username=#{username}")
    List<Student> findUserTeanumber(@Param("username") String username);
    @Select("select * from teacher where tea_number=#{teaNumber}")
    List<Teacher> findUserTeanumber1(@Param("teaNumber") int teaNumber);



    //教师查询长度
    @Select("select count(*) from user as u,student as s where user_group='学生' and u.username like CONCAT('%',#{username},'%') and stu_name like CONCAT('%',#{stuname},'%') and u.username=s.username")
    Long selectnum1(String username, String stuname);
    @Select("select count(*) from user as u,student as s where user_group='学生' and u.username like CONCAT('%',#{username},'%') and u.username=s.username")
    Long selectnum2(String username);
    @Select("select count(*) from user as u,student as s where user_group='学生' and stu_name like CONCAT('%',#{stuname},'%') and u.username=s.username")
    Long selectnum3(String stuname);




    ////分页查询学生人数的
    @Select("select * from user as u,student as s where user_group='学生' and u.username=s.username and academy=#{academy} order by stu_id desc")
    IPage<Student> findByAllPage1(Page<Student> page,@Param("academy") String academy);
    ////分页模糊查询学生人数的
    @Select("select * from user as u,student as s where user_group='学生' and u.username like CONCAT('%',#{username},'%') and u.username=s.username and academy=#{academy}")
    List<Student> selectList4(Page<Student> page, @Param("username") String username,@Param("academy") String academy);
    ////分页模糊查询学生姓名的
    @Select("select * from user as u,student as s where user_group='学生' and stu_name like CONCAT('%',#{stuname},'%') and u.username=s.username and academy=#{academy}")
    List<Student> selectList5(Page<Student> page, @Param("stuname") String stuname,@Param("academy") String academy);
    ////分页模糊查询学生姓名的
    @Select("select * from user as u,student as s where user_group='学生' and u.username like CONCAT('%',#{username},'%') and academy=#{academy} and stu_name like CONCAT('%',#{stuname},'%') and u.username=s.username")
    List<Student> selectList3(Page<Student> page,@Param("username") String username, @Param("stuname") String stuname,@Param("academy") String academy);
    //教师查询长度
    @Select("select count(*) from user as u,student as s where user_group='学生' and u.username like CONCAT('%',#{username},'%') and academy=#{academy} and stu_name like CONCAT('%',#{stuname},'%') and u.username=s.username")
    Long selectnum4(@Param("username")String username,@Param("stuname") String stuname,@Param("academy") String academy);
    @Select("select count(*) from user as u,student as s where user_group='学生' and u.username like CONCAT('%',#{username},'%') and academy=#{academy} and u.username=s.username")
    Long selectnum5(@Param("username")String username,@Param("academy") String academy);
    @Select("select count(*) from user as u,student as s where user_group='学生' and stu_name like CONCAT('%',#{stuname},'%') and academy=#{academy} and u.username=s.username")
    Long selectnum6(@Param("stuname")String stuname,@Param("academy") String academy);
}

