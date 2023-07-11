package com.ljp.filter;

import com.ljp.entity.User;
import com.ljp.service.UserService;
import com.ljp.service.impl.UserServiceImpl;
import com.ljp.util.Base64Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AutoLoginFilter",urlPatterns = "/index.jsp")
public class AutoLoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain Chain) throws IOException, ServletException {
        //1.判断是否是登录状态
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        User user= (User) request.getSession().getAttribute("user");
        if (user!=null){
            Chain.doFilter(req,resp);//放行
            return;
        }
        //2.获取cookie实现自动登录
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userinfo")) {
                    try {
                        String userinfo = cookie.getValue();
                        userinfo = Base64Utils.decode(userinfo);
                        System.out.println(userinfo);
                        String[] arr = userinfo.split("#");
                        UserService userService = new UserServiceImpl();
                        User u = userService.login(arr[0], arr[1]);
                        request.getSession().setAttribute("user", u);
                    }catch(Exception e){
                        e.printStackTrace();
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
        }
        Chain.doFilter(req,resp);
    }

    public void destroy() {

    }
}
