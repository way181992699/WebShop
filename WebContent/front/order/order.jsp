<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单结算</title>
<style type="text/css">
	td{
	width: 33%;}
	td.myTd{
		text-align: right;
		font-size: 20px;
	}
	

</style>
</head>
<body>
	<div align="center">
		<div style=" font-size: 20px; font-weight: bold; color: #157128; margin: 20px;">下订单</div>
		<div>
			<form action="../OrderServlet" method="post">
				<table border="1" cellspacing="0" bordercolor="#157128" width="800">
					<tr>
						<td class="myTd">所购商品种类数</td>
						<td>${SHOPCAR.countType }</td>
						<td></td>
					</tr>
					
					<tr>
						<td class="myTd">所购商品总件数</td>
						<td>${SHOPCAR.count }</td>
						<td></td>
					</tr>
					<tr>
						<td class="myTd">价格总计</td>
						<td>${SHOPCAR.total}</td>
						<td></td>
					</tr>
					<tr>
						<td class="myTd">订单日期</td>
						<%
							Date date = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
							String dateStr = sdf.format(date);
							request.setAttribute("dateStr", dateStr);
						%>
						<td>${dateStr}</td>
						<td></td>
					</tr>
					<tr>
						<td class="myTd">付款方式</td>
						<td>
							<select name="paytype">
								<option value="货到付款">货到付款</option>
								<option value="支付宝">支付宝</option>
								<option value="微信">微信</option>
							</select>
						</td>
						<td>
							
						</td>
					</tr>
					<tr>
						<td class="myTd">收货方式</td>
						<td>
							<select name="receivedtype">
								<option value="快递">快递</option>
								<option value="邮政">邮政</option>
								<option value="EMS">EMS</option>
							</select>
						</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="3" align="center">
						-----------------------------------------------------
						</td>
						
					</tr>
					<tr>
						<td class="myTd">收货人姓名</td>
						<td>
							<input type="text" value="${USER.truename }" name="username">
						</td>
						<td></td>
					</tr>
					<tr>
						<td class="myTd">收货人地址</td>
						<td><input type="text" value="${USER.address }" name="address"></td>
						<td></td>
					</tr>
					<tr>
						<td class="myTd">收货人邮编</td>
						<td><input type="text" value="${USER.postcade }" name="postcode"></td>
						<td></td>
					</tr>
					<tr>
						<td class="myTd">收货人电话</td>
						<td><input type="text" value="${USER.phoneno }" name="phoneno"></td>
						<td></td>
					</tr>
					<tr>
						<td class="myTd">收货人邮箱</td>
						<td><input type="text" value="${USER.email }" name="email"></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<input type="submit" value="提交">
							<input type="reset" value="重置">
						</td>
					</tr>
				
				</table>
			</form>
		</div>
	</div>
</body>
</html>