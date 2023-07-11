package com.offcn.imovie.service;

import com.offcn.imovie.pojo.Movie;

import java.util.List;

public interface MovieService {

    //数据统计右边
    public List<Movie> movieTop5();

    //模糊查询
    public List<Movie> likeQuery(String keywords);

    //电影删除
    public void deleteById(Integer id);

    //添加电影
    public void addMovie(String moviename,String time);

    //修改电影（编辑）
    public void updateMovie(Integer id,String moviename,String time,String score);
}
