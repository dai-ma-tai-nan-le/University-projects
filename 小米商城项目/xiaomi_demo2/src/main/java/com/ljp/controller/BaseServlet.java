package com.ljp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码
        request.setCharacterEncoding("utf-8");
        String methodName=request.getParameter("method");
        //反射方法
        try {
            Method method= this.getClass().getMethod(methodName,HttpServletRequest.class ,HttpServletResponse.class );
            if(method!=null){
                String url= (String) method.invoke(this,request,response);
                if(url!=null&&url.trim().length()!=0){
                    if(url.startsWith("redirect:")){
                        //重定向
                        url= url.substring(url.indexOf(":")+1);
                        response.sendRedirect(request.getContextPath()+url);
                    }else {
                        //转发
                        request.getRequestDispatcher(url).forward(request,response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
