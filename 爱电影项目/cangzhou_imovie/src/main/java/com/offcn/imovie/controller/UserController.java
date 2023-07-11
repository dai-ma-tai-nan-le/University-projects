package com.offcn.imovie.controller;

import com.offcn.imovie.pojo.User;
import com.offcn.imovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("user-show")
    public String userShow(Model model){
        List<User> userList = userService.getUserList();
        model.addAttribute("userList",userList);
        return "/users.jsp";
    }

//    跳转到登录页面
    @RequestMapping("toLogin")
    public  String toLogin(){
        return "/login.jsp";
    }

//    跳转到注册页面
    @RequestMapping("toRegister")
    public String toRegister(){
        return "/register.jsp";
    }

    /**
     * 在注册页面点击注册按钮
     * 该方法需要将表单中的账号和密码接收到
     *@Param username 方法参数名称和表单input文本框的name一致
     *@Param password
     *@return
     */
    @RequestMapping("saveRegister")
    public String saveRegister(String username, String password){
        userService.saveRegister(username,password);
        //注册完跳转到登陆页面
        return "redirect:/user/toLogin";
    }

    @RequestMapping("login")
    public String login(String username,String password,HttpSession session) {
        //TODO
        //调用service-》dao 实现登录效验
        boolean bol = userService.checkLogin(username, password);
        if (bol) {
            //账号和密码验证通过，将用户名存储到session对象中，
            // 这样在主页就可以使用session存储的用户名
            session.setAttribute("username",username);

            //如果效验通过，接下来跳转到系统主页
            return "redirect:/main/toIndex";
        }else{
            //账号密码有误
            return "/login_fail.jsp";
        }
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){
        //实现注销（注销session）
        session.invalidate();
        //跳转到登录页面
        return "redirect:/user/toLogin";
    }
}






