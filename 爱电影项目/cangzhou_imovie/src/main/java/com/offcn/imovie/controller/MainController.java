package com.offcn.imovie.controller;

import com.offcn.imovie.pojo.Movie;
import com.offcn.imovie.pojo.Performer;
import com.offcn.imovie.service.DataService;
import com.offcn.imovie.service.MovieService;
import com.offcn.imovie.service.PerformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("main")
@Controller
public class MainController {

    @Autowired
    PerformService performService;

    @Autowired
    MovieService  movieService;

    @Autowired
    DataService dataService;

    /**
     * 登陆成功后调用
     * 跳转到系统主页main.jsp
     * @return
     */
    @RequestMapping("toIndex")
    public String toIndex(Model model){
        List<Movie> movies = movieService.movieTop5();
        List<Performer> performers=performService.performerTop5();
        //将这两个集合带入main.jsp上进行遍历显示
        model.addAttribute("movies",movies);
        model.addAttribute("performers",performers);

        return "/main.jsp";
    }

    @RequestMapping("toData")
    public String toData(Model model){

        //实现数据统计中每一个总数
        Map data = dataService.data();
        model.addAttribute("data",data);

        //跳转到数据统计页面
        return  "/data.jsp";
    }
}
