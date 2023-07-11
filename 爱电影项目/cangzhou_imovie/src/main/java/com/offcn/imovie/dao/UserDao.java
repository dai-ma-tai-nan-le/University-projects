package com.offcn.imovie.dao;

import com.offcn.imovie.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
//执行和用户相关的
public interface UserDao {

    @Select("select * from user")
    public List<User> getUserlist();

    @Insert("insert into user(username,password) value(#{username},#{password})")
    void saveRegister(@Param("username") String username,@Param("password") String password);

    @Select("select * from user where username=#{username} and password=#{password}")
    List<User> findByUsernameAndPassword(@Param("username")String username,
                                         @Param("password")String password);

}
