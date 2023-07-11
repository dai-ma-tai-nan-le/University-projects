package com.offcn.imovie.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.offcn.imovie.dao.MovieDao;
import com.offcn.imovie.pojo.Movie;
import com.offcn.imovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieDao movieDao;

    public List<Movie> movieTop5() {
        List<Movie> movies=movieDao.movieTop5();
        return movies;
    }

    public List<Movie> likeQuery(String keywords) {
        List<Movie> movies=movieDao.likeQuery("%"+keywords+"%");
        return movies;
    }

    public void deleteById(Integer id) {
        if(id<0){
            throw new RuntimeException("参数有误");
        }
        movieDao.deleteById(id);
    }

    public void  addMovie(String moviename,String time){
        //写添加的业务逻辑
        //1,先做参数校验，检查参数是否为空
        //如果电影名或时长为空，则抛出异常
        if(StringUtils.isEmpty(moviename)||StringUtils.isEmpty(time)){
            throw new RuntimeException("参数不能为空");
        }
        //2,如果参数校验通过，调用dao方法实现添加
        movieDao.addMovie(moviename,time);
    }

    public void updateMovie(Integer id, String moviename, String time, String score) {
        movieDao.updateMovie(id,moviename,time,score);
    }
}
