<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>爱电影后台项目</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css">
    <script src="${pageContext.request.contextPath}/assets/js/echarts.min.js"></script>
</head>

<body data-type="index">


<%--此处设置头部分--%>
<jsp:include page="/header.jsp"></jsp:include>
<%--此处设置头部分--%>

<%--此处设置左侧部分--%>
<jsp:include page="/left.jsp"></jsp:include>
<%--此处设置左侧部分--%>


<div class="tpl-page-container tpl-page-header-fixed">


    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            <a href="/category/categoryList">返回</a>
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home"></a></li>
            <li class="am-active"></li>
        </ol>
        <div class="tpl-content-scope">
            <div class="note note-info">
                <h3>

                    <%--大分类名称--%>
                    <font size="25px">大分类名称：${vo.categroy}</font><br><span class="close" data-close="note"></span><hr>

                    <%--小分类列表--%>
                    <c:forEach items="${vo.titles}" var="title">
                        <span>${title}</span> &nbsp;&nbsp;&nbsp;
                        <a href="/category/deleteTitle?categroy=${vo.categroy}&title=${title}">删除</a>
                        <a href="/category/toEdit?category=${vo.categroy}&title=${title}">重命名</a> <br>
                    </c:forEach>

                </h3>

            </div>
        </div>


    </div>


</div>

</div>


<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/iscroll.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
</body>

</html>