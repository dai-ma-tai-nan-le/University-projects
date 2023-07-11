package com.ljp.demo.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 教师(Teacher)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-16 20:20:29
 */
@Mapper
public interface TeacherDao {

    ////分页查询教师人数的
    @Select("select * from user as u,teacher as t where user_group='教师' and u.username=t.username order by tea_id desc")
    IPage<Teacher> findByAllPage(Page<Teacher> page);
    ////分页模糊查询教师人数的
    @Select("select * from user as u,teacher as t where user_group='教师' and u.username like CONCAT('%',#{username},'%') and u.username=t.username")
    List<Teacher> selectList(Page<Teacher> page, @Param("username") String username);
    ////分页模糊查询教师姓名的
    @Select("select * from user as u,teacher as t where user_group='教师' and tea_name like CONCAT('%',#{teaname},'%') and u.username=t.username")
    List<Teacher> selectList1(Page<Teacher> page, @Param("teaname") String teaname);
    ////分页模糊查询教师姓名的
    @Select("select * from user as u,teacher as t where user_group='教师' and u.username like CONCAT('%',#{username},'%') and tea_name like CONCAT('%',#{teaname},'%') and u.username=t.username")
    List<Teacher> selectList2(Page<Teacher> page,@Param("username") String username, @Param("teaname") String teaname);
    ///查教师重名
    @Select("select * from user where username=#{username}")
    List<User> findUserByUsername(@Param("username") String username);
    ///查重名教师id
    @Select("select * from teacher where tea_number=#{teanumber}")
    List<Teacher> findUserTeanumber(@Param("teanumber") int teanumber);

    //添加教师员
    @Insert("insert into user values(null,#{userGroup},#{loginTime},#{phone},#{username},#{password},#{status},#{email},#{avatar},#{createTime})")
    void adduname(User user);
    @Insert("insert into teacher values(null,#{teaNumber},#{teaName},#{gender},#{courses},#{faculties},#{examineState},#{username},#{createTime},#{updateTime})")
    void addtea(Teacher teacher);
    //删除教师员
    @Delete("delete from user where username=#{username}")
    void deltea(@Param("username") String username);
    @Delete("delete from teacher where username=#{username}")
    void deltea1(@Param("username") String username);
    //修改教师员
    @Update("update user set user_group=#{userGroup},phone=#{phone},status=#{status},email=#{email} where username=#{username}")
    void modtea(User user);
    @Update("update teacher set tea_number=#{teaNumber},tea_name=#{teaName},gender=#{gender},courses=#{courses},faculties=#{faculties},examine_state=#{examineState} where username=#{username}")
    void modtea1(Teacher teacher);

    ////查询教师的
    @Select("select * from user as u,teacher as t where user_group='教师' and u.username=#{username} and u.username=t.username")
    List<Teacher> selectteaList(@Param("username") String username);



    //教师查询长度
    @Select("select count(*) from user as u,teacher as t where user_group='教师' and u.username like CONCAT('%',#{username},'%') and tea_name like CONCAT('%',#{teaname},'%') and u.username=t.username")
    Long selectnum1(@Param("username") String username,@Param("teaname") String teaname);
    @Select("select count(*) from user as u,teacher as t where user_group='教师' and u.username like CONCAT('%',#{username},'%') and u.username=t.username")
    Long selectnum2(@Param("username") String username);
    @Select("select count(*) from user as u,teacher as t where user_group='教师' and tea_name like CONCAT('%',#{teaname},'%') and u.username=t.username")
    Long selectnum3(@Param("teaname") String teaname);
}

