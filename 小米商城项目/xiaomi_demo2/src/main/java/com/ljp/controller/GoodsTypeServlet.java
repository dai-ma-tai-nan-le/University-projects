package com.ljp.controller;

import com.alibaba.fastjson.JSON;
import com.ljp.entity.GoodsType;
import com.ljp.service.GoodsTypeService;
import com.ljp.service.impl.GoodsTypeServiceImpl;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/goodstypeservlet")
public class GoodsTypeServlet extends BaseServlet {
    public String goodstypelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        ServletContext application = this.getServletContext();
        String goodsType = (String) application.getAttribute("goodsType");
        if (goodsType==null){
            System.out.println("访问了数据库。。。");
            GoodsTypeService goodsTypeService=new GoodsTypeServiceImpl();
            List<GoodsType> goodsTypesList=goodsTypeService.findAll();
            System.out.println(goodsTypesList);
            //把集合转成json字符串
            goodsType=JSON.toJSONString(goodsTypesList);
            application.setAttribute("goodsType",goodsType);
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(goodsType);
        return null;
    }
}
