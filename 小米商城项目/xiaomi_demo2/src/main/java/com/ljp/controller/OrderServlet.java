package com.ljp.controller;

import com.ljp.entity.*;
import com.ljp.service.AddressService;
import com.ljp.service.CartService;
import com.ljp.service.OrderService;
import com.ljp.service.impl.AddressServiceImpl;
import com.ljp.service.impl.CartServiceImpl;
import com.ljp.service.impl.OrderServiceImpl;
import com.ljp.util.RandomUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet",urlPatterns = "/orderservlet")
public class OrderServlet extends BaseServlet {
    //订单预览 getOrderView
    public String getOrderView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login.jsp";
        }
        //(1)获取购物车的信息
        CartService cartService=new CartServiceImpl();
        List<CartGoods> cartList = cartService.findByUid(user.getUid());
        if(cartList==null||cartList.size()==0){
            request.setAttribute("msg","购物车为空" );
            return "/message.jsp";
        }
        //(2)获取收货地址
        AddressService addressService=new AddressServiceImpl();
        List<Address> addresses=addressService.findByUid(user.getUid());
        System.out.println("addresses="+addresses);
        System.out.println("cartList="+cartList);
        //(3)放入域中
        request.setAttribute("cartList", cartList);
        request.setAttribute("addList", addresses);

        return "/order.jsp";
    }

    //提交订单addOrder
    public String addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login.jsp";
        }
        String aid = request.getParameter("aid");
        //获取购物车的数据
        CartService cartService=new CartServiceImpl();
        List<CartGoods> cartList = cartService.findByUid(user.getUid());
        if(cartList==null||cartList.size()==0){
            request.setAttribute("msg","购物车为空请添加商品到购物车");
            return "/message.jsp";
        }
        //创建订单号
        String oid = RandomUtils.createOrderId();
        //创建订单详情
        List<OrderDetail> orderDetails = new ArrayList<>();
        BigDecimal sum = new BigDecimal(0);
        for (CartGoods cart : cartList) {
            OrderDetail orderDetail = new OrderDetail(0,oid,cart.getPid(),cart.getCcount(),cart.getCnum());
            orderDetails.add(orderDetail);
            sum = sum.add(cart.getCcount());
        }
        //创建订单
        Order order = new Order(oid, user.getUid(),Integer.parseInt(aid), sum,new Date(),0);
        //创建业务
        try {
            OrderService orderService = new OrderServiceImpl();
            orderService.saveOrder(order,orderDetails);
            request.setAttribute("order",order);
            return "/orderSuccess.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","订单提交失败"+e.getMessage());
            return "/message.jsp";
        }
    }
}
