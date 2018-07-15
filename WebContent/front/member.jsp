<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
		String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
	// http://localhost:8081/Day13_Shop/
	%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>无标题文档</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/member.css" rel="stylesheet" type="text/css">
</head>

<body>
<%-- <%@ include file="top.jsp" %> --%>
<jsp:include page="top.jsp">
	<jsp:param value="2" name="flag"/>
</jsp:include>
<div id="m_content">
   <div id="m_c_left">
      
         <div id="m_c_left_bottom">
             <p class="m_c_left_title">会员中心
             </p>
            
                 <ul>
                   <li><a href="#" target="myiframe">基本资料显示</a></li>
                   <li><a href="#" target="myiframe">用户资料修改</a></li>
                   <li><a href="#" target="myiframe">密码修改</a></li>
                   <li><a href="front/OrderServlet?task=query" target="myiframe">我的订单</a></li>
                 </ul>
              
               
        </div>
   </div>
   <div id="m_c_right">
     <iframe id="myiframe" name="myiframe" frameborder="0" width="700" height="500">
     	
     </iframe>
   </div>
</div>
     
     
</body>
</html>
