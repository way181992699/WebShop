<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="border: #157128 1px solid; width: 100%; height: 400px;">
		<table border="1" cellspacing="0" bordercolor="#157128"
		style="width: 100%">
			<tr>
				<th>订单编号</th>
				<th>收货人姓名</th>
				<th>地址</th>
				<th>总价</th>
				<th>数量</th>
			</tr>
			<c:forEach var="order" items="${page.list }">
				<tr>
					<td>${order.orderid }</td>
					<td>${order.username }</td>
					<td>${order.address }</td>
					<td>${order.totalprice }</td>
					<td>${order.quantity }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../../HomePage.jsp"></jsp:include>
	<form action="OrderServlet?task=query" id="pageForm" method="post">
				<input type="hidden" value="${page.currentPage }" id="currentPage" name="currentPage">
				<input type="hidden" value="${page.pageSize }" id="pageSize" name="pageSize">
	</form>
           
</body>
</html>