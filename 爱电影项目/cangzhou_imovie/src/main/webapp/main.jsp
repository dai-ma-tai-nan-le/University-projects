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
            首页
        </div>
        <ol class="am-breadcrumb">
            <li><a href="" class="am-icon-home">首页</a></li>
            <%--            <li><a href="#">分类</a></li>--%>
            <%--<li class="am-active">内容</li>--%>
            <li class="am-active">数据列表</li>
        </ol>

        <div class="row">
            <%--电影--%>
            <div class="am-u-md-6 am-u-sm-12 row-mb">
                <div class="tpl-portlet">
                    <div class="tpl-portlet-title">
                        <div class="tpl-caption font-green ">
                            <span>电影列表</span>
                        </div>
                    </div>

                    <div class="am-tabs tpl-index-tabs" data-am-tabs>
                        <ul class="am-tabs-nav am-nav am-nav-tabs">
                            <li><a href="#tab2">更多...</a></li>
                        </ul>

                        <div class="am-tabs-bd">
                            <div class="am-tab-panel am-fade" id="tab2">
                                <div id="wrapperB" class="wrapper">
                                    <div id="scroller" class="scroller">
                                        <ul class="tpl-task-list tpl-task-remind">



                                            <%--遍历model中的movies集合--%>
                                            <c:forEach items="${movies}" var="movie">
                                                <%--for循环每执行一次，都会生成一个li--%>
                                                <li>
                                                    <div class="cosB">
                                                        <%--电影分数--%>
                                                            ${movie.score}
                                                    </div>
                                                    <div class="cosA">
                                                        <span class="cosIco">
                                                            <i class="am-icon-file-movie-o"></i>
                                                        </span>
                                                        <span>
                                                            <%--电影名称--%>
                                                                ${movie.moviename}
                                                        </span>
                                                    </div>
                                                </li>
                                            </c:forEach>





                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <%--演员--%>
            <div class="am-u-md-6 am-u-sm-12 row-mb">
                <div class="tpl-portlet">

                    <div class="tpl-portlet-title">
                        <div class="tpl-caption font-green ">
                            <span>演员列表</span>
                        </div>

                    </div>

                    <div class="am-tabs tpl-index-tabs" data-am-tabs>
                        <ul class="am-tabs-nav am-nav am-nav-tabs">
                            <li><a href="#tab2">更多...</a></li>
                        </ul>

                        <div class="am-tabs-bd">
                            <div class="am-tab-panel am-fade" id="tab2">
                                <div id="wrapperB" class="wrapper">
                                    <div id="scroller" class="scroller">
                                        <ul class="tpl-task-list tpl-task-remind">

                                            <%--遍历演员列表--%>

                                            <c:forEach items="${performers}" var="performer">
                                                <li>
                                                    <div class="cosB">
                                                        <%--演员名称--%>
                                                            ${performer.name}
                                                    </div>
                                                    <div class="cosA">
                                                        <span class="cosIco">
                                                            <i class="am-icon-star"></i>
                                                        </span>
                                                        <span>
                                                            <%--如果演员介绍字段长度大于5，只显示前5个字符--%>
                                                            <c:if test="${performer.des != null && performer.des.length() >= 5}">
                                                                ${performer.des.substring(0,5)}...
                                                            </c:if>
                                                            <c:if test="${performer.des != null && performer.des.length() < 5}">
                                                                ${performer.des}
                                                            </c:if>
                                                        </span>
                                                    </div>
                                                </li>
                                            </c:forEach>



                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

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
