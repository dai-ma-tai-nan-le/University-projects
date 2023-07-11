package com.ljp.controller;

import com.ljp.entity.Cart;
import com.ljp.entity.CartGoods;
import com.ljp.entity.Goods;
import com.ljp.entity.User;
import com.ljp.service.CartService;
import com.ljp.service.GoodsService;
import com.ljp.service.impl.CartServiceImpl;
import com.ljp.service.impl.GoodsServiceImpl;
import com.ljp.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(urlPatterns = "/cartservlet")
public class CartServlet extends BaseServlet {
    public String addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.判断是否是登录状态
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:/login.jsp";
        }
        //2.获取数据
        String goodsId = request.getParameter("goodsId");
        String number = request.getParameter("number");
        //3.校验数据
        if (StringUtils.isEmpty(goodsId)){
            //添加购物车失败
            return "/message.jsp";
        }
        int num=1;
        if (!StringUtils.isEmpty(number)){
           try {
               num=Integer.parseInt(number);
               if (num<1||num>5){
                   num=1;
               }
           }catch (Exception e){
               e.printStackTrace();
           }
        }
        //4.创建业务对象
        CartService cartService=new CartServiceImpl();
        Cart cart=cartService.findByUidAndPid(user.getUid(),Integer.parseInt(goodsId));
        GoodsService goodsService=new GoodsServiceImpl();
        Goods goods=goodsService.findById(Integer.parseInt(goodsId));
        if (goods==null){
            request.setAttribute("msg","添加购物车失败");
            return "/message.jsp";
        }
//        System.out.println("cart:" +cart);
        try {
            if (cart==null){//添加数据
                System.out.println("添加购物车。。。");
//                System.out.println("user.getUid()="+user.getUid());
//                System.out.println("goodsId="+Integer.parseInt(goodsId));
//                System.out.println("count="+goods.getPprice().multiply(new BigDecimal(num)));
//                System.out.println("num="+num);
                cart=new Cart(0,user.getUid(),Integer.parseInt(goodsId),goods.getPprice().multiply(new BigDecimal(num)),num);
                System.out.println("cart   ="+cart);
                cartService.add(cart);
            }else {//更新数据
                cart.setCnum(cart.getCnum()+num);
                cart.setCcount(goods.getPprice().multiply(new BigDecimal(cart.getCnum())));
                cartService.update(cart);
            }
            return "/cartSuccess.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg","添加失败");
            return "/message.jsp";
        }
    }

    public String getCart(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login.jsp";
        }
        //创建业务对象
        CartService cartService=new CartServiceImpl();
//        System.out.println("user.getUid()="+user.getUid());
        List<CartGoods> cartList= cartService.findByUid(user.getUid());
//        System.out.println(cartList);
        if(cartList==null||cartList.size()==0){
            request.setAttribute("msg","购物车为空，请选择要购买的商品");
            return "/message.jsp";
        }
//        System.out.println(cartList.toString());
        request.setAttribute("cartList", cartList);
        return "/cart.jsp";

    }

    public String addCartAjax(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return null;
        }

        //(1)获取数据goodsId="+pid+"&number="+num
        String goodsId = request.getParameter("goodsId");
        String number = request.getParameter("number");
        int num=1;
        if(!StringUtils.isEmpty(number)){
            try {
                num=Integer.parseInt(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        CartService cartService=new CartServiceImpl();
//        System.out.println("user.getUid(), Integer.parseInt(goodsId)="+user.getUid()+"  "+ Integer.parseInt(goodsId));
        Cart cart=cartService.findByUidAndPid(user.getUid(), Integer.parseInt(goodsId));
        //(2)根据num
        try {
            if(num==1||num==-1){//修改
                //查询商品
                GoodsService goodsService=new GoodsServiceImpl();
                Goods goods = goodsService.findById(Integer.parseInt(goodsId));
                if(cart!=null&&goods!=null){
                    cart.setCnum(cart.getCnum()+num);
                    cart.setCcount(goods.getPprice().multiply(new BigDecimal(cart.getCnum())));
                    cartService=new CartServiceImpl();
                    cartService.update(cart);
                }
            }else if(num==0){//删除
                cartService=new CartServiceImpl();
                cartService.delete(user.getUid(),Integer.parseInt(goodsId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String clearCartAjax(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return null;
        }
        CartService cartService=new CartServiceImpl();
        try {
            cartService.deleteByUid(user.getUid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
