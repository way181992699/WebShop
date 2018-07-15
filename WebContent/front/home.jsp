<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
		String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
	// http://localhost:8081/Day13_Shop/
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>无标题文档</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
	// 将购买的商品添加到购物车中
	function shop(mcid){
		// 通ajax的方式提交到服务器
		// 1.获取XMLHttpRequest对象
		var xmlhttp = new XMLHttpRequest();
		// 2.发送请求
		xmlhttp.open("GET","ShopCarServlet?mcid="+mcid,true);
		xmlhttp.send();
		// 3.获取响应的数据
		xmlhttp.onreadystatechange = function(){
			if(xmlhttp.readyState == '4' && xmlhttp.status== '200'){
				document.getElementById("shopCount").innerHTML= xmlhttp.responseText;
			}
		}
	}

</script>

<body>
<%-- <%@ include file="top.jsp" %> --%>
<jsp:include page="top.jsp">
	<jsp:param value="0" name="flag"/>
</jsp:include>
<div id="m_content">
   <div id="m_c_left">
        <div id="m_c_left_notice">
             <p class="m_c_left_title">公告栏
             </p>
        </div>
         <div id="m_c_left_bottom">
             <p class="m_c_left_title">商品分类
             </p>
             <c:forEach var="big" items="${typeList }">
             	<c:if test="${big.fatherid eq 0 }">
		             <dl>
		               <dt>${big.typename}</dt>
		               <dd>
		                 <ul>
		                 	<c:forEach var="small" items="${typeList }">
		                 		<c:if test="${small.fatherid eq big.typeid }">
		                   			<li>${small.typename }</li>
		                   		</c:if>
		                   </c:forEach>
		                 </ul>
		               </dd>
		              </dl>
	              </c:if>
               </c:forEach>
               
               </div>
   </div>
   <div id="m_c_right">
     
   
       <c:forEach var="mc" items="${page.list }">
	        <div class="m_c_rgt_product">
	          <div class="mcrp_lft">
	          <img src="upload/${mc.pic }" style="" width="150" height="150" />
	          <p>
	            <a>查看大图</a>
	          </p>
	        </div>
	          <div class="mcrp_rgt">
	           <h3 >${mc.mcname }</h3>
	           <p>单价：<font  color="red">￥${mc.price }</font></p>
	           <p>是否缺货：${mc.flag eq 0?'缺':'否' }</p>
	           <p class="product_desc"> ${mc.mcdecx}</p>
	           <p class="product_btn">
	           <a href="#"><img src="img/detail.jpg" width="70" height="22"></a>
	            <a href="javaScript:shop(${mc.mcid});"><img src="img/pay.jpg"></a>
	           </p>
	          </div>
	       </div>
       </c:forEach>
         <hr/>
         <jsp:include page="../HomePage.jsp"></jsp:include>
   			
   </div>
</div>
     
     
</body>
</html>
