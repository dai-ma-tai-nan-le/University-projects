package com.offcn.imovie.controller;

import com.offcn.imovie.pojo.Movie;
import com.offcn.imovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    /**
     * 点击左侧菜单栏“电影列表”要进行调用
     * @return
     */
    @RequestMapping("show-movie")
    public String showMovie(Model model){
        List<Movie> movies=movieService.movieTop5();
        model.addAttribute("movies",movies);

        return "/movielist.jsp";
    }

    /**
     * movielist.jsp上输入关键词，点击查询按钮要调用
     * @param model
     * @param keywords 文本框输入的关键词
     * @return
     */
    @RequestMapping("likeQuery")
    public String likeQuery(Model model,String keywords){

        List<Movie> movies=movieService.likeQuery(keywords);
        model.addAttribute("movies",movies);
        model.addAttribute("keywords",keywords);

        return "/movielist.jsp";
    }

    /**
     * 点击删除按钮，调用该方法
     * @param id
     * @return
     */
    @RequestMapping("deleteById")
    public String deleteById(Integer id){
        //删除电影
        movieService.deleteById(id);
        //成功后重新加载电影列表
        return "redirect:/movie/show-movie";
    }

    /**
     * 点击菜单栏的电影添加，调用该方法来跳转到添加页面
     * @return
     */
    @RequestMapping("toAdd")
    public  String toAdd(){
        return "/addmovie.jsp";
    }

    @RequestMapping("addMovie")
    public String addMovie(String moviename,String time){
        movieService.addMovie(moviename,time);
        //成功后重新加载电影列表
        return "redirect:/movie/show-movie";
    }

    /**
     * 点击编辑按钮，调用该方法来跳转到修改页面
     * @return
     */
    @RequestMapping("toEdit")
    public  String toEdit(Model model,Integer id,String moviename,String time,String score){
        model.addAttribute("id",id);
        model.addAttribute("moviename",moviename);
        model.addAttribute("time",time);
        model.addAttribute("score",score);

        return "/editmovie.jsp";
    }

    /**
     * 点击编辑页面中的保存按钮，调用该方法，实现更新操作
     * @param id
     * @param moviename
     * @param time
     * @param score
     * @return
     */
    @RequestMapping("updateMovie")
    public String updateMovie(Integer id,String moviename,String time,String score){
        movieService.updateMovie(id,moviename,time,score);
        //成功后重新加载电影列表
        return "redirect:/movie/show-movie";
    }
}
