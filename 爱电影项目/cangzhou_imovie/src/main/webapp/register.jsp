<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/24
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />


    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css">
</head>

<%--打开页面，对flag进行判断--%>
<%--model中的flag--%>
<c:if test="${flag!=null && flag == '1'}">
    <script>
        alert('用户名被占用')
    </script>
</c:if>

<body data-type="login">

<div class="am-g myapp-login">
    <div class="myapp-login-logo-block  tpl-login-max">
        <div class="myapp-login-logo-text">
            <div class="myapp-login-logo-text">
                Amaze UI<span> Login</span> <i class="am-icon-skyatlas"></i>

            </div>
        </div>

        <div class="login-font">
            <i>Log In </i> or <span> Sign Up</span>
        </div>
        <div class="am-u-sm-10 login-am-center">

            <%--用户输入账号 密码 确认密码--%>
            <form id="registerForm" class="am-form" method="post" action="/user/saveRegister">
                <fieldset>
                    <div class="am-form-group">
                        <%--用户名--%>
                        <input name="username" type="text" class="" id="username" placeholder="请输入用户名">
                    </div>
                    <div class="am-form-group">
                        <%--密码--%>
                        <input name="password" type="password" class="" id="doc-ipt-pwd-1" placeholder="输入密码">
                    </div>
                    <div class="am-form-group">
                        <%--确认密码--%>
                        <input name="confirmPassword" type="password" class="" id="doc-ipt-pwd-2" placeholder="再次输入密码">
                    </div>
                    <%--按钮被点击--%>
                    <p><button type="button" onclick="userRegister()" class="am-btn am-btn-default">注册</button></p>
                </fieldset>
            </form>

        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

<script>
    <%--点击注册按钮要调用--%>
    function userRegister() {
        //先判断两次密码是否一致
        var pwd1 = $("#doc-ipt-pwd-1").val();
        var pwd2 = $("#doc-ipt-pwd-2").val();

        //判断是否为空
        if(pwd1=='' || pwd1 == null){
            alert('请输入密码')
            return;
        }
        if(pwd2=='' || pwd2 == null){
            alert('请输入确认密码')
            return;
        }
        if(pwd1 != pwd2){
            alert('两次密码不一致，请检查')
            return;
        }

        //校验用户名
        var username = $("#username").val();
        if(username=='' || username == null){
            alert('用户名不能为空');
            return;
        }


        //如果两个密码不为空，且一致，可以提交表单
        $("#registerForm").submit();
    }
</script>

</body>

</html>
