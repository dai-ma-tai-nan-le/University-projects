package com.offcn.imovie.dao;

import org.apache.ibatis.annotations.Select;

public interface DataDao {

    @Select("select count(*) from movietable")
    public int movieNum();

    @Select("select count(*) from performerdetailtable")
    public int performerNum();

    @Select("select count(*) from categroymovietable")
    public int categoryNum();

    @Select("select count(*) from user")
    public int userNum();
}
