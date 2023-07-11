<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品列表</title>
</head>
<body>
<table width="800" align="center" border="0"
       style="border: 1px solid rgba(214,214,214,1)" >
    <tr style="height: 30px">
        <td style="margin-top: 10px">
            &nbsp;&nbsp;产品列表&nbsp;&nbsp;
            <input type="button" id="btnAdd" value="添加产品"
                   onclick="add()" style="background-color:deepskyblue;  color:#FFF">
        </td>
    </tr>
    <tr>
        <td>
            <table border="0" width="100%" cellpadding="10" cellspacing="0"
                   style="border-top: 1px solid rgba(214,214,214,1)" >
                <tr align="center">
                    <td>序号</td>
                    <td>产品名称</td>
                    <td>产品类型</td>
                    <td>生产厂家</td>
                    <td>是否上架销售</td>
                    <td>操作</td>
                </tr>
                <c:forEach var="product" items="${productlist}" varStatus="varstatus">
                <tr align="center">
                    <td style="border-top: 1px solid rgba(214,214,214,1)">
                        <c:out value="${varstatus.index+1}"/>  <%--自增一--%>
                    </td>
                    <td style="border-top: 1px solid rgba(214,214,214,1)">${product.productName}</td>
                    <td style="border-top: 1px solid rgba(214,214,214,1)">${product.productType}</td>
                    <td style="border-top: 1px solid rgba(214,214,214,1)">${product.manufacturer}</td>
                    <td style="border-top: 1px solid rgba(214,214,214,1)">
                        <c:if test="${product.canSale=='1'}">是</c:if>
                        <c:if test="${product.canSale=='0'}">否</c:if>
                    </td>
                    <td style="border-top: 1px solid rgba(214,214,214,1)">
                        <input type="button" id="btnEdit" value="修改"
                               style="background-color:aqua; color: blue"
                               onclick="edit(${product.productId})">
                        <input type="button" id="btnDel" value="删除"
                               style="background-color: #ffdbe2; color: red"
                               onclick="del(${product.productId})">
                    </td>
                </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>

<script>
    function add() {
        window.location.href
            ="${pageContext.request.contextPath}/toproductadd";
    }
    function edit(id) {
        window.location.href
            ="${pageContext.request.contextPath}/toproductedit?productId="+id;
    }
    function del(id) {
        if(confirm("要删除该数据吗?")){
            window.location.href
                ="${pageContext.request.contextPath}/productdelete?productId="+id;
        }
    }
</script>
</body>
</html>
