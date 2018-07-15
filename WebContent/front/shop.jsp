<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
// http://localhost:8081/Day13_Shop/
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车管理界面</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/member.css" rel="stylesheet" type="text/css">

</head>
	<script type="text/javascript">
		// 清空购物车
		function  shopClear(){
			location.href="ShopCarServlet?task=clear";
		}
		// 继续购物
		function goShopping(){
			location.href="index.jsp"
		}
		// 删除购物车中的商品
		function shopDelete(mcid){
			// 将需要删除的商品的编号传递到servlet中
			location.href="ShopCarServlet?task=delete&mcid="+mcid;
		}
		// 更新购物车中的商品数量
		function shopUpdate(mcid,num){
			location.href = "ShopCarServlet?task=update&mcid="+mcid+"&num="+num;
		}
		// 下订单
		function goOrder(){
			location.href="front/order/order.jsp";
		}
	</script>
<body>
	<jsp:include page="top.jsp"><jsp:param value="4" name="flag"/></jsp:include>
	<div align="center">
		<div style="font-weight: bold; color: #157128; font-size: 20px; margin: 10px; ">购物车管理</div>
		<div>
			<table bordercolor="#157128" border="1" cellspacing="0" width="800">
				<tr bgcolor="#157128">
					<th>商品略缩图</th>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>商品数量</th>
					<th>商品小计</th>
					<th>操作</th>
				</tr>
				<c:forEach var="mc" items="${SHOPCAR.list}">
					<tr align="center">
						<td><img alt="不存在" src="upload/${mc.pic }"></td>
						<td>${mc.mcname }</td>
						<td>${mc.price }</td>
						<td>
							<input type="text" onblur="shopUpdate(${mc.mcid},this.value);"
							style="width: 50px;" value="${mc.shopNum }">
						</td>
						<td>${mc.price*mc.shopNum}</td>
						<td><input type="button" value="删除" onclick="shopDelete(${mc.mcid});"></td>
					</tr>
				
				</c:forEach>
			</table>
		</div>
		<div style="border: #157128 1px solid; margin-top:10px; width: 800px;" >
			商品种类数:${SHOPCAR.countType } 
			| 商品总个数：${SHOPCAR.count }
			|商品总价:${SHOPCAR.total}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="清空购物车" onclick="shopClear();">
			<input type="button" value="继续购物" onclick="goShopping();">
			<input type="button" value="结算下单" onclick="goOrder();">
		</div>
	</div>
</body>
</html>