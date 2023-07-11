<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/28
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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

<body data-type="generalComponents">


<%--此处设置头部分--%>
<jsp:include page="/header.jsp"></jsp:include>
<%--此处设置头部分--%>

<%--此处设置左侧部分--%>
<jsp:include page="/left.jsp"></jsp:include>



<div class="tpl-page-container tpl-page-header-fixed">


    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            <%--Amaze UI 表单--%>
                电影添加
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">电影信息</a></li>
            <%--<li><a href="#">表单</a></li>--%>
            <%--<li class="am-active">Amaze UI 表单</li>--%>
            <li class="am-active">电影添加</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 表单
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                            <i class="am-icon-search"></i>
                            <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                    </div>
                </div>


            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">


                    <div class="am-u-sm-12 am-u-md-9">




                        <%--输入电影名称和时长--%>

                        <form class="am-form am-form-horizontal" method="post" action="/movie/addMovie">
                            <!-- 这是一个input开始 -->
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">电影名称</label>
                                <div class="am-u-sm-9">
                                    <input name="moviename" type="text" id="user-name" placeholder="电影名称">
                                    <small></small>
                                </div>
                            </div>
                            <!-- 这是一个input结束 -->
                            <div class="am-form-group">
                                <label for="user-email" class="am-u-sm-3 am-form-label">总时长</label>
                                <div class="am-u-sm-9">
                                    <input name="time" type="text" id="user-email" placeholder="总时长">
                                    <small></small>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="submit" class="am-btn am-btn-primary">添加</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>


<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

</body>

</html>
