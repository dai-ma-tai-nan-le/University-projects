package com.ljp.controller;

import com.ljp.entity.Goods;
import com.ljp.entity.PageBean;
import com.ljp.service.GoodsService;
import com.ljp.service.impl.GoodsServiceImpl;
import com.ljp.service.impl.GoodsTypeServiceImpl;
import com.ljp.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/goodsservlet")
public class GoodsServlet extends BaseServlet {
    //分页查询
   public String getGoodsListByTypeId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       //1.接收分页的参数
       String pageNum = request.getParameter("pageNum");
       String pageSize = request.getParameter("pageSize");
       //设置默认值
       int pn=1;
       int ps=8;
       //判断
       try {
           if (!StringUtils.isEmpty(pageNum)){
               pn=Integer.parseInt(pageNum);
               if (pn<1){
                   pn=1;
               }
           }
           if (!StringUtils.isEmpty(pageSize)){
               ps=Integer.parseInt(pageSize);
               if (ps<1){
                   ps=8;
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       //2.创建Map集合
       Map<String,Object> condition=new HashMap<>();
       condition.put("pageNum",pn);
       condition.put("pageSize",ps);
       condition.put("start",(pn-1)*ps);
       //3.获取查询
       String typeId= request.getParameter("typeId");
       String name = request.getParameter("name");
       if (name!=null){
           if(name.equals("红米") || name.equals("红") || name.equals("米") || name.equals("红米4") || name.equals("红米4")){
               typeId="1";
           }
           if(name.equals("红米4手机壳") || name.equals("米4手机壳") || name.equals("4手机壳") || name.equals("手机壳") || name.equals("机壳")){
               typeId="2";
           }
       }
       System.out.println(typeId+"   "+name);
       try {
//           System.out.println(typeId+"   "+name);
           condition.put("typeId",Integer.parseInt(typeId));
       }catch (Exception e){
           e.printStackTrace();
           typeId=null;
       }
       condition.put("name",name);
       //空判断
       if (StringUtils.isEmpty(typeId)&&StringUtils.isEmpty(name)){
           return "redirect:/index.jsp";
       }
//       4.创建业务对象
       try {
           GoodsService goodsService=new GoodsServiceImpl();
           PageBean<Goods> pageBean=goodsService.findByPage(condition);
//           System.out.println(pageNum.getTotalSize()+"..."+pageBean.getPageCount());
           //5.放域中
           request.setAttribute("pageBean",pageBean);
           request.setAttribute("typeId",typeId);
           request.setAttribute("name",name);
           return "/goodsList.jsp";
       }catch (Exception e){
           e.printStackTrace();
           request.setAttribute("msg","查询失败"+e.getMessage());
           return "/message.jsp";
       }
   }

   //根据id查询商品，
    public String getGoodsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       //1.获取参数
        String id = request.getParameter("id");
        if (StringUtils.isEmpty(id)){
            request.setAttribute("msg","未查询到商品");
            return "/message";
        }
        //2.创建业务对象
        GoodsService goodsService=new GoodsServiceImpl();
        //3.调用方法
        try {
            Goods goods=goodsService.findById(Integer.parseInt(id));
            System.out.println(goods.toString());
            request.setAttribute("goods",goods);
            return "/goodsDetail.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg","未查询到商品"+e.getMessage());
            return "/message";
        }
    }
}
