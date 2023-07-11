<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改产品信息</title>
</head>
<body>
<form id="frmProduct" name="frmProduct" method="post">
    <input type="hidden" name="productId" value="${product.productId}">
    <table width="800" border="0" align="center"
           style="border: 1px solid rgba(214,214,214,1)">
        <tr style="height: 30px">
            <td style="margin-top: 10px">
                &nbsp;&nbsp;修改产品信息&nbsp;&nbsp;
                <input type="button" id="btnCancel" value="x"
                       onclick="cancel()" style="float: right">
            </td>
        </tr>
        <tr>
            <td>
                <table border="0" width="100%" cellspacing="0" cellpadding="10"
                       style="border-top: 1px solid rgba(214,214,214,1)">
                    <tr >
                        <td align="right" width="25%">
                            <font color="red">*</font>产品名称:</td>
                        <td>
                            <input type="text" name="productName" size="50"
                                   value="${product.productName}">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">产品类型:</td>
                        <td>
                            <select name="productType">
                                <option value="手机"
                                        <c:if test="${product.productType=='手机'}">
                                            selected</c:if>>&nbsp;手机&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                <option value="食品"
                                        <c:if test="${product.productType=='食品'}">
                                            selected</c:if>>&nbsp;食品</option>
                                <option value="图书"
                                        <c:if test="${product.productType=='图书'}">
                                            selected</c:if>>&nbsp;图书</option>
                                <option value="家电"
                                        <c:if test="${product.productType=='家电'}">
                                            selected</c:if>>&nbsp;家电</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">是否上架:</td>
                        <td>
                            <input type="radio" name="canSale" value="0"
                                    <c:if test="${product.canSale=='1'}">
                                        checked</c:if> />是
                            <input type="radio" name="canSale" value="0"
                                    <c:if test="${product.canSale=='0'}">
                                        checked</c:if> />否
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="25%">生产厂家:</td>
                        <td>
                            <input type="text" name="manufacturer" size="50"
                                   value="${product.manufacturer}">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center">
                <div align="center">
                    <input type="button" id="btnSave"
                           style="background-color: deepskyblue; color:#FFF"
                           value="保存" onclick="save()">
                    <input type="button" id="btnCancel1"
                           value="取消" onclick="cancel()">
                </div>
            </td>
        </tr>
    </table>
</form>

<script>
    function save() {
        document.frmProduct.action
            = "${pageContext.request.contextPath}/productedit";
        document.frmProduct.submit();
    }
    function cancel() {
        window.location.href
            ="${pageContext.request.contextPath}/productlist";
    }
</script>
</body>
</html>
