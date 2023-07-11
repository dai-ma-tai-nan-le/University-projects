package com.ljp.demo.dao;

import com.ljp.demo.entity.Accomplishment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 成就(Accomplishment)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-26 16:53:09
 */
@Mapper
public interface AccomplishmentDao {

    //查询该用户有没有这个成就
    @Select("select * from accomplishment where username=#{username} and name=#{name}")
    List<Accomplishment> selectCj(@Param("username")String username,@Param("name") String name);
    //添加成就
    @Insert("insert into accomplishment values(null,#{username},#{name},#{condition},#{createTime})")
    void insertCj(Accomplishment accomplishment);



    //查询该用户的成就
    @Select("select * from accomplishment where username=#{username}")
    List<Accomplishment> selectAllcj(@Param("username")String username);
}

