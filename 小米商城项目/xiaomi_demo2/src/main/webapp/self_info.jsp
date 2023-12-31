<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 
 
<title>个人中心-收货地址页面</title>
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
	function deleteAddr(id){
		var res = confirm("是否删除");
		if(res==true){
			window.location.href="userservlet?method=deleteAddress&id="+id;
		}
	}
	function defaultAddr(id){
		var res = confirm("是否设为默认");
		if(res==true){
			window.location.href="userservlet?method=defaultAddress&id="+id;
			
		}
	}
</script>
</head>
<body>
<%@ include file="header.jsp"%>
<!--网站中间内容开始-->
<div id="dingdanxiangqing_body">
    <div id="dingdanxiangqing_body_big">
        <div id="big_left">
           	   <p style="font-size:18px;margin-top: 15px">订单中心</p>
               <a id="big_left_a" href="dingdanxiangqing.html">我的订单</a><br/>
               <a id="big_left_a" href="">意外保</a><br/>
               <a id="big_left_a" href="">团购订单</a><br/>
               <a id="big_left_a" href="">评价晒单</a><br/>
               <p style="font-size:18px">个人中心</p>
               <a id="big_left_a" href="self_info.html">我的个人中心</a><br/>
               <a id="big_left_a" href="">消息通知</a><br/>
               <a id="big_left_a" href="">优惠券</a><br/>
               <a id="big_left_a" href="">收货地址</a><br/>
        </div>
     <div id="big_right" style="height: 500px;overflow: scroll;">
     
         <div style="margin:0 20px;">
	         <h3>收货地址</h3>
	         <hr>
	         <table class="table table-striped table-hover table-bordered">
				<tr>
					<th>序号</th><th>收件人</th>
					<th>手机号</th><th>地址</th>
					<th>操作</th>
				</tr>
				<c:forEach var="address" items="${addList}" varStatus="i" >
					<tr>
						<Td>${i.count}</Td>
						<td>${address.aname}</td>
						<td>${address.aphone}</td>
						<td>${address.adetail}</td>
						<td>
							<button onclick="deleteAddr(${address.aid})" class="btn btn-danger btn-sm">删除</button>&nbsp;&nbsp;
							<button class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal${address.aid}">修改</button>&nbsp;&nbsp;
							<!-- 弹出模态框 -->
							
							<div class="modal fade" tabindex="-1" role="dialog" id="myModal${address.aid}">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span>&times;</span>
										</button>
										<h4 class="modal-title">修改地址</h4>
									</div>
									<form action="userservlet?method=updateAddress" method="post" class="form-horizontal">
										<div class="motal-body">
											<div class="form-group">
												<label class="col-sm-2 control-label">收件人</label>
												<div class="col-sm-10">
													<input type="hidden" name="id"  value="${address.aid}">
													<input type="hidden" name="level" value="${address.astate}">
													<input type="text" name="name" class="form-control" value="${address.aname}">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">电话</label>
												<div class="col-sm-10">
													<input type="text" name="phone" class="form-control" value="${address.aphone}">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">收件人</label>
												<div class="col-sm-10">
													<input type="text" name="detail" class="form-control" value="${address.adetail}">
												</div>
											</div>
											
										</div>
										<div class="motal-footer">
											<button type="submit" class="btn btn-primary">修改</button>
										</div>
									</form>
								</div>
							</div>
							</div>
							
							<button onclick="defaultAddr(${address.aid})" class="btn btn-primary btn-sm">设为默认</button>
							<c:if test="${address.astate==1}">
								<span class="badge" style="background-color:red;">默认</span>
							</c:if>
							<c:if test="${address.astate==0}">
								<span class="badge">普通</span>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br>
		<div class="container" style="width:960px;">
		
			<form action="" method="post" class="form-horizontal" id="form1">
				<div class="form-group">
				    <label class="col-sm-2 form-label">收件人</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="name" id="name"/>
				    </div>
				</div>
		  		<div class="form-group">
				    <label class="col-sm-2 form-label">手机号</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="phone" id="phone"/>
				    </div>
				</div>	
				<div class="form-group">
					<label class="form-label">详细地址</label>
					<textarea rows="3" class="form-control" name="detail" id="detail" ></textarea>
				</div>
				<div class="form-group col-md-12">
					<input type="button" class="btn btn-primary" value="添加地址" onclick="submitForm()">
				</div>
				<input type="hidden" value="${loginUser.id}" name="uid">
			</form>
	      </div>
       </div>
    </div>
	<script type="text/javascript">
		$.ajaxSetup({
			error:function (xhr) {
				if(xhr.responseText==4){
					if(xhr.status==404){
						alert("地址不存在");
					}else if(xhr.status==500){
						alert("服务器错误");
					}else if(xhr.status==0){
						alert("网络异常");
					}else{
						alert("未知错误");
					}
				}
			}
		});
		function submitForm(){
			//判断
			if($("#name").val()==null||$("#name").val().trim().length==0){
				alert("收件人不能为空");
				return;
			}
			if($("#phone").val()==null||$("#phone").val().trim().length==0){
				alert("手机号不能为空");
				return;
			}
			if($("#detail").val()==null||$("#detail").val().trim().length==0){
				alert("详细地址不能为空");
				return;
			}
			//获取参数
			$.post("userservlet?method=addAddress",$("#form1").serialize(),function (){
				window.location="userservlet?method=getAddress";
			});
		}
	</script>
</div>
	
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>