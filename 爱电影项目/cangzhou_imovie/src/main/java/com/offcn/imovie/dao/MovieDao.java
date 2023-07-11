package com.offcn.imovie.dao;

import com.offcn.imovie.pojo.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MovieDao {
    //数据统计右边
    @Select("select * from movietable order by score desc limit 5")
    public List<Movie> movieTop5();

    //模糊查询
    @Select("select * from movietable where moviename like #{keywords}")
    public  List<Movie> likeQuery(String keywords);

    //电影删除
    @Delete("delete from movietable where id=#{id}")
    public void deleteById(Integer id);

    @Insert("insert into movietable(moviename,time,saveimagepath,score,source) VALUE(#{moviename},#{time},'/photo/default.jpg',10,'cangzhou')")
    void addMovie(@Param("moviename") String moviename, @Param("time") String time);

    @Update("update movietable set moviename=#{moviename} ,time=#{time},score=#{score} where id = #{id}")
    void updateMovie(@Param("id") Integer id, @Param("moviename") String moviename, @Param("time") String time,@Param("score") String score);


}
