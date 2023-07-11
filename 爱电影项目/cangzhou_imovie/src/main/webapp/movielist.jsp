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
            电影列表
        </div>
        <ol class="am-breadcrumb">
            <li><a href="" class="am-icon-home">电影信息</a></li>
            <li><a href="">电影列表</a></li>
            <li class="am-active">内容</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <%--新增电影按钮--%>
                            <div class="am-btn-group am-btn-group-xs">
                                <a href="/movie/toAdd"> <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button></a></div>
                        </div>
                    </div>

                    <%--模糊查询--%>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">

                                <%--右上角的模糊查询--%>
                                <form action="/movie/likeQuery" method="post">
                                       输入电影名称关键词： <input value="${keywords}" type="text" name="keywords">
                                        <input type="submit" value="查询">
                                </form>

                        </div>
                    </div>


                </div>


                <div class="am-g">
                    <div class="tpl-table-images">

                        <%--电影列表展示--%>
                            <%--pageInfo.list 当前页的电影的集合--%>
                        <c:forEach items="${movies}" var="movie">
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                                <div class="tpl-table-images-content">
                                    <div class="tpl-table-images-content-i-time">发布时间：暂无</div>
                                    <div class="tpl-i-title">
                                        <%--电影名称--%>
                                            ${movie.moviename}
                                    </div>
                                    <a href="javascript:;" class="tpl-table-images-content-i">
                                        <div class="tpl-table-images-content-i-info">
                                            <span class="ico">
                                                <%--电影的图片--%>
                                                <img src="${pageContext.request.contextPath}${movie.saveimagepath}" alt="">
                                            </span>
                                        </div>
                                        <span class="tpl-table-images-content-i-shadow"></span>
                                        <img src="${pageContext.request.contextPath}${movie.saveimagepath}" alt="">
                                    </a>
                                    <div class="tpl-table-images-content-block">
                                        <div class="tpl-i-font">
                                            <%--你最喜欢的作品，告诉大家它们是什么------大声的叫出来。。。。--%>
                                        </div>
                                        <div class="tpl-i-more">
                                            <ul>                                                    <%--分数--%>
                                                <li><span class="am-icon-star am-text-warning"> ${movie.score}</span></li>
                                            </ul>
                                        </div>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs tpl-edit-content-btn">

                                                <%--编辑按钮--%>
                                                <button type="button" onclick="toEdit(${movie.id},'${movie.moviename}','${movie.time}','${movie.score}')" class="am-btn am-btn-default am-btn-secondary">
                                                    <span class="am-icon-edit"></span> 编辑</button>
                                                <button type="button" onclick="deleteById(${movie.id})" class="am-btn am-btn-default am-btn-danger">
                                                    <span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="tpl-alert"></div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/iscroll.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
<%--表单：保存要跳转到的页码，以及其他--%>
<form id="movieForm" action="${pageContext.request.contextPath}/movie/show-movie" method="post">
    <%--保存页码--%>
    <input name="currentPage" id="currentPage" type="hidden">
    <%--保存搜索列表的选项--%>
    <%--<input name="area" id="地区" type="hidden">--%>
    <%--<input name="type" id="类型" type="hidden">--%>
    <%--<input name="style" id="规格" type="hidden">--%>
    <%--<input name="year" id="我的年代" type="hidden">--%>
    <%--<input name="mname" id="电影名称" type="hidden">--%>
    <%--保存关键字-搜索值--%>
    <%--<input name="keyword" id="keyword2" type="hidden">--%>
</form>
</body>
<script type="text/javascript">

    /**
     * 点击删除按钮，调用该方法
     * @param id
     */
    function deleteById(id){
        var bol=confirm('是否确定删除？')
        if (bol){
            //调用public String deleteById(Integer id)方法
            location.href="/movie/deleteById?id="+id;
        }
    }

    function toEdit(id,moviename,time,score){
        location.href="/movie/toEdit?id="+id+"&moviename="+moviename+"&time="+time+"&score="+score;
    }

</script>



</html>