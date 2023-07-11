<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/31
  Time: 19:14
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

<body data-type="generalComponents">



<jsp:include page="/header.jsp"></jsp:include>
<%--此处设置头部分--%>

<%--此处设置左侧部分--%>
<jsp:include page="/left.jsp"></jsp:include>

<div class="tpl-page-container tpl-page-header-fixed">



    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            <%--Amaze UI 文字列表--%>
            分类列表
        </div>
        <ol class="am-breadcrumb">
            <li><a href="#" class="am-icon-home">电影分类</a></li>
            <li><a href="#">分类列表</a></li>
            <%--<li class="am-active">文字列表</li>--%>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 列表
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                            <i class="am-icon-search"></i>
                            <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                    </div>
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <button onclick="toAddPage()" type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                <button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>
                                <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>
                                <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                            </div>
                        </div>
                    </div>


                    <form action="/performer/listQueryList" method="post">

                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-form-group">


                                <%--声明本次的模糊查询的查询字段--%>
                                <select name="fieldName" data-am-selected="{btnSize: 'sm'}">

                                    <c:if test="${fieldName==null || fieldName=='name'}">
                                        <option value="name" selected>姓名</option>
                                        <option value="address" >地址</option>
                                        <option value="des">介绍</option>
                                    </c:if>

                                    <c:if test="${fieldName!=null && fieldName=='address'}">
                                        <option value="name" >姓名</option>
                                        <option value="address" selected>地址</option>
                                        <option value="des">介绍</option>
                                    </c:if>

                                    <c:if test="${fieldName!=null && fieldName=='des'}">
                                        <option value="name" >姓名</option>
                                        <option value="address" >地址</option>
                                        <option value="des" selected>介绍</option>
                                    </c:if>


                                </select>


                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <br>
                        <div class="am-input-group am-input-group-sm">

                            <%--输入关键词的地方--%>
                            <input type="text" name="keyword" value="${keyword}" class="am-form-field">

                            <%--查询按钮--%>
                            <span class="am-input-group-btn">
                                <button  class="am-btn
                                am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                                         type="submit"></button>
                            </span>
                        </div>
                    </div>
                    </form>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">




                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                    <tr>
                                        <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                        <th class="table-title">序号</th> <%--从1开始--%>

                                        <th class="table-title">大分类名称</th>
                                        <th class="table-title">小分类列表</th>
                                        <th>操作</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <%--遍历--%>
                                    <%--model中的集合名称--%>
                                    <%--外层遍历大分类--%>
                                    <c:forEach items="${voList}" var="vo" varStatus="state">
                                        <tr>
                                            <td><input type="checkbox"></td>

                                            <td><a href="#">${state.index+1}</a></td>  <%--序号--%>

                                            <td><a href="/category/toVoPage?categroy=${vo.categroy}">
                                                    ${vo.categroy}</a>
                                            </td> <%--大分类名称--%>

                                            <td>
                                                <%--遍历小分类--%>
                                                <c:forEach items="${vo.titles}" var="t">
                                                    ${t} &nbsp;&nbsp;
                                                </c:forEach>
                                            </td>

                                            <td>

                                                <%--每一行后的删除按钮--%>
                                                <%--参数是大分类名称--%>
                                                <input onclick="deleteByCategory('${vo.categroy}')" type="button" value="删除">

                                            </td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled"><a href="#">«</a></li>
                                        <li class="am-active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
                                </div>
                            </div>
                            <hr>
                        </form>
                    </div>
                </div>
            </div>
            <div class="tpl-alert"></div>
        </div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

<script type="text/javascript">
    function deleteById(id) {
        location.href = "/performer/deleteById?id="+id;
    }

    //点击修改按钮调用
    function edit(id) {
        var bol = confirm("是否确定修改？")
        if(bol){
            location.href = "/performer/findById?id="+id;
        }
    }

    function copyPerformer(id) {
        var bol  = confirm("是否复制？")
        if(bol){
            location.href="/performer/copyPerformer?id="+id;
        }
    }

    function copyPerformer2(id) {
        var bol  = confirm("是否复制？")
        if(bol){
            location.href="/performer/copyPerformer2?id="+id;
        }
    }

    function toAddPage() {
        location.href="/category/toAdd";//调用路径/category/toAdd的controller方法
    }


    function deleteByCategory(categroy) {
        var bol = confirm("是否删除？");
        if(bol){
            location.href = "/category/deleteByCategroy?categroy="+categroy;
        }
    }

</script>

</body>

</html>