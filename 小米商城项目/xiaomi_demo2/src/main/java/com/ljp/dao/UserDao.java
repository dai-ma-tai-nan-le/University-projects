package com.ljp.dao;


import com.ljp.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where u_name=#{username} and u_password=#{password}")
    User selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    @Insert("insert into user values(null,#{username},#{upassword},#{usex},#{ustatus},#{code},#{email},#{urole})")
    int insertUser(User user);

    @Select("select * from user where u_name=#{username}")
    User selectByUsername(@Param("username") String username);
}
