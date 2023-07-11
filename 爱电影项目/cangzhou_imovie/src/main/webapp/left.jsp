<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>爱电影后台项目</title>
</head>
<body>
<div class="tpl-left-nav tpl-left-nav-hover">
    <div class="tpl-left-nav-title">
        <%--后台管理界面导航--%>
        后台电影系统导航
    </div>
    <div class="tpl-left-nav-list">
        <ul class="tpl-left-nav-menu">
            <li class="tpl-left-nav-item">

                <%--进入系统首页--%>
                <a href="${pageContext.request.contextPath}/main/toIndex" class="nav-link">
                    <i class="am-icon-home"></i>
                    <span>首页</span>
                </a>
            </li>
            <li class="tpl-left-nav-item">

                <%--controller方法--%>
                <a href="/main/toData" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-bar-chart"></i>
                    <span>数据统计</span>
                </a>

            </li>


            <li class="tpl-left-nav-item">
                <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-wpforms"></i>
                    <span>电影信息</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                </a>
                <ul class="tpl-left-nav-sub-menu">
                    <li>


                        <%--点击之后，调用一个路径是 movie/show-movie的controller方法--%>
                        <a href="/movie/show-movie">
                            <i class="am-icon-angle-right"></i>
                            <span>电影列表</span>
                        </a>


                        <%--点击a标签，接下来要去调用路径 movie/toAdd的方法--%>
                        <a href="/movie/toAdd">
                            <i class="am-icon-angle-right"></i>
                            <span>电影添加</span>
                        </a>

                    </li>
                </ul>
            </li>

            <li class="tpl-left-nav-item">
                <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-wpforms"></i>
                    <span>电影分类</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                </a>
                <ul class="tpl-left-nav-sub-menu">
                    <li>
                        <a href="/category/categoryList">
                            <i class="am-icon-angle-right"></i>
                            <span>分类列表</span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="tpl-left-nav-item">
                <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-wpforms"></i>
                    <span>演员信息</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                </a>
                <ul class="tpl-left-nav-sub-menu">
                    <li>



                        <a href="/performer/list">
                            <i class="am-icon-angle-right"></i>
                            <span>演员列表</span>
                        </a>



                        <a href="/performer/toAdd">
                            <i class="am-icon-angle-right"></i>
                            <span>演员添加</span>
                        </a>
                    </li>
                </ul>
            </li>


            <li class="tpl-left-nav-item">
                <a href="${pageContext.request.contextPath}/user/logout" class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-key"></i>
                    <span>注销</span>
                </a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
