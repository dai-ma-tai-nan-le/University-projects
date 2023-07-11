package com.ljp.controller;

import com.ljp.util.PaymentUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PayServlet", value = "/payservlet")
public class PayServlet extends BaseServlet {
    public String pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String url = "https://www.yeepay.com/app-merchant-proxy/node?";
        //订单号
        String orderid = request.getParameter("orderid");
        //银行通道
        String pd_FrpId = request.getParameter("pd_FrpId");
        String p0_Cmd = "Buy";
        String p1_MerId = "10001126856";
        String p2_Order = orderid;
        String p3_Amt = "0.01";
        String p4_Cur = "CNY";
        String p5_pid = "";
        String p6_pcat = "";
        String p7_pdesc = "";
        String p8_Url = "http://localhost:8080/callback";
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        String keyValue = "69c1522AV6q613Ii4W6u8k6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4P1";
        String hmac = PaymentUtil.buildHmac(p0_Cmd,p1_MerId,p2_Order,p3_Amt,p4_Cur,
                p5_pid,p6_pcat,p7_pdesc,p8_Url,p9_SAF,pa_MP,pd_FrpId,pr_NeedResponse,keyValue);
        response.sendRedirect(url);
        //发送给第三方
        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_pid=").append(p5_pid).append("&");
        sb.append("p6_pcat=").append(p6_pcat).append("&");
        sb.append("p7_pdesc=").append(p7_pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac).append("&");
        response.sendRedirect(sb.toString());
        return null;
    }
}
