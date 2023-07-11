package com.ljp.controller;

import com.ljp.service.OrderService;
import com.ljp.service.impl.OrderServiceImpl;
import com.ljp.util.PaymentUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(name = "CallBackServlet", value = "/callback")
public class CallBackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接受支付结果");
        String p1_merId = request.getParameter("p1_MerId");
        String r0_cmd = request.getParameter("r0_Cmd");
        String r1_code = request.getParameter("r1_Code");
        String r2_trxId = request.getParameter("r2_TrxId");
        String r3_amt = request.getParameter("r3_Amt");
        String r4_cur = request.getParameter("r4_Cur");
        String r5_pid = request.getParameter("r5_Pid");
        String r6_order = request.getParameter("r6_Order");
        String r7_uid = request.getParameter("r7_Uid");
        String r8_mp = request.getParameter("r8_Mp");
        String r9_bType = request.getParameter("r9_BType");
        String rb_bankId = request.getParameter("rb_BankId");
        String ro_bankOrderId = request.getParameter("ro_BankOrderId");
        String rp_payDate = request.getParameter("rp_PayDate");
        String rq_carNo = request.getParameter("rq_CarNo");
        String ru_trxtime = request.getParameter("ru_Trxtime");
        String hmac = request.getParameter("hmac");
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
        boolean isValid = PaymentUtil.verifyCallback(hmac,p1_merId,r0_cmd,r1_code,r2_trxId,
                r3_amt,r4_cur,r5_pid,r6_order,r7_uid,r8_mp,r9_bType,keyValue);
        if (isValid){
            if (r9_bType.equals("1")){
                System.out.println("111");
                request.setAttribute("msg","您的订单号为："+r6_order+",金额为："+r3_amt+"已经支付成功，等待发货。。。");
            }else if (r9_bType.equals("2")){
                System.out.println("222");
                response.getWriter().print("success");
            }
            //修改订单状态
            OrderService orderService = new OrderServiceImpl();
            orderService.updateStatus(r6_order,"2");
        }else {
            System.out.println("数据被篡改！");
            request.setAttribute("msg","订单支付失败");
        }
        request.getRequestDispatcher("/message.jsp").forward(request,response);
    }
}
