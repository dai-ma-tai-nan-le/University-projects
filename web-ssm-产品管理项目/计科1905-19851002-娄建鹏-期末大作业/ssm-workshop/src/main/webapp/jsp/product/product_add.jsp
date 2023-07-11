<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加产品</title>
</head>
<body>
<form id="frmProduct" name="frmProduct" method="post">
    <table width="800" border="0" align="center"
           style="border: 1px solid rgba(214,214,214,1)">
        <tr style="height: 30px">
            <td style="margin-top: 10px">
                &nbsp;&nbsp;会员注册&nbsp;&nbsp;
                <input type="button" id="btnCancel" value="x"
                        onclick="cancel()" style="float: right">
            </td>
        </tr>
        <tr>
            <td>
                <table border="0" width="100%" cellspacing="0" cellpadding="10"
                       style="border-top: 1px solid rgba(214,214,214,1)">
                    <tr>
                        <td align="right" width="25%" size="50">
                            <font color="red">*</font>产品名称:</td>
                        <td >
                            <input type="text" name="productName" size="50">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">产品类型:</td>
                        <td>
                            <select  size="" name="productType">
                                <option value="0" selected>&nbsp;请选择产品类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                <option value="手机">&nbsp;手机</option>
                                <option value="食品">&nbsp;食品</option>
                                <option value="图书">&nbsp;图书</option>
                                <option value="家电">&nbsp;家电</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">是否上架:</td>
                        <td>
                            <input type="radio" name="canSale" value="1" checked/>是
                            <input type="radio" name="canSale" value="0"/>否
                        </td>
                    </tr>
                    <tr>
                        <td align="right">生产厂家:</td>
                        <td>
                            <input type="text" name="manufacturer" size="50">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center">
                <div align="center">
                    <input type="button" id="btnAdd"
                           style="background-color: deepskyblue; color:#FFF"
                           value="保存" onclick="add()">
                    <input type="button" id="btnCancel1"
                           value="取消" onclick="cancel()">
                </div>
            </td>
        </tr>
    </table>
</form>

<script>
    function add() {
        document.frmProduct.action
            = "${pageContext.request.contextPath}/productadd";
        document.frmProduct.submit();
    }
    function cancel() {
        window.location.href
            ="${pageContext.request.contextPath}/productlist";
    }
</script>
</body>
</html>
