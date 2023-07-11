package com.offcn.imovie.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategroyDao {

    //查询所有的大分类名称
    @Select("select distinct categroy from categroymovietable")
    public List<String> categroyList();

    //根据大分类名称查询它的小分类名称集合
    @Select("select title from categroymovietable where categroy=#{categroy}")
    public List<String> getTitlesByCategroy(String categroy);

    //根据大分类名称删除分类
    @Delete("delete from categroymovietable where categroy=#{categroy}")
    public void deleteByCategroy(String categroy);

    //删除小分类
    @Delete("delete from categroymovietable where categroy=#{categroy} and title=#{title}")
    public void deleteTitle(@Param("categroy") String categroy,@Param("title") String title);
}
