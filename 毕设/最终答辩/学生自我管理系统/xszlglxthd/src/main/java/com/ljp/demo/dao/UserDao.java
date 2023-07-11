package com.ljp.demo.dao;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Student;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.User;
import org.apache.ibatis.annotations.*;


import java.util.Date;
import java.util.List;

/**
 * 用户账户：用于保存用户登录信息(User)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-10 13:25:14
 */
@Mapper
public interface UserDao extends BaseMapper<User>{

    @Select("select * from user where username=#{wrapper}")
    List<User> selectList(QueryWrapper<User> wrapper);

    ////查询管理员的
    @Select("select * from user where user_group='管理员' and username=#{username}")
    List<User> selectGlyList(@Param("username") String username);
    //总条数
    @Select("select count(*) from user where user_group='管理员'")
    Long allTotal();
    ////分页查询管理员人数的
    @Select("select * from user where user_group='管理员' ${ew.customSqlSegment} order by user_id desc")
    IPage<User> findByAllPage(Page<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);
    ////分页模糊查询管理员人数的
    @Select("select * from user where user_group='管理员' and username like CONCAT('%',#{username},'%')")
    List<User> selectList(Page<User> page, @Param("username") String username);
    ///查管理员重名
    @Select("select * from user where username=#{username}")
    List<User> findUserByUsername(@Param("username") String username);

    //添加管理员
    @Insert("insert into user values(null,#{userGroup},#{loginTime},#{phone},#{username},#{password},#{status},#{email},#{avatar},#{createTime})")
    void addgly(User user);
    //删除管理员
    @Delete("delete from user where username=#{username}")
    void delgly(@Param("username") String username);
    //修改管理员
    @Update("update user set user_group=#{userGroup},phone=#{phone},status=#{status},email=#{email} where username=#{username}")
    void modgly(User user);

    //登录查询学生信息的
    @Select("select * from user as u,student as s where user_group='学生' and u.username=#{username} and u.username=s.username")
    List<Student> selectstuList(@Param("username")String username);
    //登录查询教师信息的
    @Select("select * from user as u,teacher as t where user_group='教师' and u.username=#{username} and u.username=t.username")
    List<Teacher> selectteaList(String username);
    //更新登录时间的
    @Update("update user set login_time=#{loginTime} where username=#{username}")
    void modlogintime(Date loginTime,@Param("username")String username);
    //修改密码
    @Update("update user set password=#{password} where username=#{username}")
    void updatePassword(User user);


    //教师查询长度
    @Select("select count(*) from user where user_group='管理员' and username like CONCAT('%',#{username},'%')")
    Long selectnum1(@Param("username")String username);
}

