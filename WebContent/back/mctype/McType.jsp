<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别信息</title>
</head>
<body>
	<!-- 
		获取servlet中传递过来的数据 显示出来 
		jstl展示数据
	-->
	<div align="center">
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>父类别编号</th>
			</tr>
			<c:forEach var="type" items="${list }">
				<tr>
					<td>${type.typeid }</td>
					<td>${type.typename }</td>
					<td>${type.fatherid }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>