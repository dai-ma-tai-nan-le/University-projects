package com.ljp.controller;

import cn.dsna.util.images.ValidateCode;
import com.ljp.entity.Address;
import com.ljp.entity.User;
import com.ljp.service.AddressService;
import com.ljp.service.UserService;
import com.ljp.service.impl.AddressServiceImpl;
import com.ljp.service.impl.UserServiceImpl;
import com.ljp.util.Base64Utils;
import com.ljp.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/userservlet")
public class UserServlet extends BaseServlet {
    //注册
    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.获取数据
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String repassword=request.getParameter("repassword");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        //回填
        request.setAttribute("username",username);
        request.setAttribute("password",password);
        request.setAttribute("repassword",repassword);
        request.setAttribute("email",email);
        request.setAttribute("gender",gender);
        //2.校验
        //2.1 非空校验
        if(StringUtils.isEmpty(username)){
            request.setAttribute("msg","用户名不能为空");
            return "/register.jsp";
        }
        if(StringUtils.isEmpty(password)){
            request.setAttribute("msg","密码不能为空");
            return "/register.jsp";
        }
        if(!password.equals(repassword)){
            request.setAttribute("msg","两次密码不一致");
            return "/register.jsp";
        }
        if(StringUtils.isEmpty(email)){
            request.setAttribute("msg","邮箱不能为空");
            return "/register.jsp";
        }
        //2.2格式校验
        String regs="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        if (!email.matches(regs)){
            request.setAttribute("msg","邮箱格式不正确");
            return "/register.jsp";
        }
        //3. 创建业务对象
        UserService userService=new UserServiceImpl();
        //4. 调用方法
        try {
            User user=new User(0,username,password,email,gender,"1","",1);
//            System.out.println(username);
//            System.out.println(password);
//            System.out.println(user);
            userService.regist(user);
            return "/registerSuccess.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg","注册失败"+e.getMessage());
            return "/register.jsp";
        }

//        System.out.println("注册成功");
        //转发到成功页面
//        request.getRequestDispatcher("/registSuccess.jsp").forward(request,response);
//        return "/registSuccess.jsp";
    }

    //登录
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.接收数据
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String code=request.getParameter("code");
        String auto=request.getParameter("auto");
        //2.校验
        //2.1 非空校验
        if(StringUtils.isEmpty(username)){
            request.setAttribute("msg","用户名不能为空");
            return "/login.jsp";
        }
        if(StringUtils.isEmpty(password)) {
            request.setAttribute("msg", "密码不能为空");
            return "/login.jsp";
        }
        if(StringUtils.isEmpty(code)) {
            request.setAttribute("msg", "验证码不能为空");
            return "/login.jsp";
        }
        //2.2验证码校验
        String serverCode = (String) request.getSession().getAttribute("serverCode");
        if(!code.equalsIgnoreCase(serverCode)){
            request.setAttribute("msg", "验证码输入有误");
            return "/login.jsp";
        }
        //3.创建业务对象
        UserService userService=new UserServiceImpl();
        try {
            User user=userService.login(username,password);
//            System.out.println("user="+user);
            request.getSession().setAttribute("user",user);
            //auto
            //判断是否勾选自动登录
            if (auto!=null){
                System.out.println("勾选了auto");
                //base64编码
                String userinfo=username+"#"+password;
                System.out.println(userinfo);
                userinfo=Base64Utils.encode(userinfo);
                Cookie cookie=new Cookie("userinfo",userinfo);
                cookie.setMaxAge(60*60*24*14);
//                cookie.setPath("/");
                response.addCookie(cookie);
            }
            return "redirect:/index.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "登录失败"+e.getMessage());
            return "/login.jsp";
        }

//        System.out.println("登录成功");
        //重定向到首页
//        response.sendRedirect("index.jsp");
//        return "redirect:/index.jsp";
    }

    //检查用户名是否存在
    public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("username");
//        System.out.println(username);
        if(StringUtils.isEmpty(username)){
            response.getWriter().write("1");
            return null;
        }
        //创建业务对象
        UserService userService=new UserServiceImpl();
//        System.out.println(username);
        boolean b=userService.checkUserName(username);
//        System.out.println(b);
        if(b){
            response.getWriter().write("1");
        }else {
            response.getWriter().write("0");
        }
        return null;
    }

    //返回验证码方法
    public String code(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       //图片高度，宽度，验证字符个数，干扰线。
        ValidateCode validateCode=new ValidateCode(100,30,4,20);
        String code=validateCode.getCode();
        System.out.println(code);
        request.getSession().setAttribute("serverCode",code);
        validateCode.write(response.getOutputStream());
        return null;
    }

    //退出
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        //1.删除session中的数据
        session.removeAttribute("user");
        //2.session失效
        session.invalidate();
        //3.删除cookie
        Cookie cookie=new Cookie("userinfo","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        //4.重定向
        return "redirect:/login.jsp";
    }

    //添加收货地址
    public String addAddress(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return null;
        }

        //获取信息
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String detail = request.getParameter("detail");

        if(StringUtils.isEmpty(name)){
            return null;
        }
        if(StringUtils.isEmpty(phone)){
            return null;
        }
        if(StringUtils.isEmpty(detail)){
            return null;
        }
//        System.out.println(name+"..."+phone+"..."+detail);
        Address address=new Address(0,  user.getUid(), name, phone,detail, 0);
        AddressService addressService=new AddressServiceImpl();
        try {
            addressService.addAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取收货地址getAddress
    public String getAddress(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login.jsp";
        }
        try {
            AddressService addressService=new AddressServiceImpl();
            List<Address> addList = addressService.findByUid(user.getUid());
            request.setAttribute("addList", addList);
            return "/self_info.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","获取地址失败");
            return "/message.jsp";
        }
    }

    //删除收货地址 deleteAddress&id=10
    public String deleteAddress(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login.jsp";
        }
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            request.setAttribute("msg","删除地址失败" );
            return "/message.jsp";
        }
        try {
            AddressService addressService=new AddressServiceImpl();
            addressService.deleteById(Integer.parseInt(id));
            return "redirect:/userservlet?method=getAddress";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("msg","删除地址失败,地址可能已经被使用..." );
            return "/message.jsp";
        }
    }

    //修改收货地址 updateAddress
    public String updateAddress(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login.jsp";
        }
        //获取参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String detail = request.getParameter("detail");
        String level = request.getParameter("level");
        //校验

        //封装成对象
        try {
            Address address=new Address(Integer.parseInt(id), user.getUid(), name, phone,  detail, Integer.parseInt(level));
            AddressService addressService=new AddressServiceImpl();
            addressService.update(address);
            return "redirect:/userservlet?method=getAddress";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("msg","修改地址失败" );
            return "/message.jsp";
        }
    }

    //默认地址 method=defaultAddress&id=12
    public String defaultAddress(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login.jsp";
        }
        try {
            String id = request.getParameter("id");
            AddressService addressService=new AddressServiceImpl();
            addressService.defaultAddress(user.getUid(),Integer.parseInt(id));
            return "redirect:/userservlet?method=getAddress";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("msg","修改地址失败" );
            return "/message.jsp";
        }
    }
}


