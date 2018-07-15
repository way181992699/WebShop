<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://"
	 +request.getServerName()+":"
	 +request.getServerPort()+path+"/";
// http://localhost:8081/Day13_Shop/
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>

<script type="text/javascript">
	// 根据id删除数据
	function deleteType(id){
		var flag = window.confirm("确定要删除该条记录吗?");
		if(flag){
			// 将删除数据的需求提交给servlet
			location.href='back/McTypeServlet?task=delete&typeid='+id;
		}
	}

</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">商品信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click">
        	<a href="back/mc/McAdd.jsp">
        		<span>
        			<img src="images/t01.png" />
        		</span>
        		添加
        	</a>
        </li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>
        
			<form action="back/McServlet" id="pageForm">
				<input type="hidden" value="${page.currentPage }" id="currentPage" name="currentPage">
				<input type="hidden" value="${page.pageSize }" id="pageSize" name="pageSize">
				<input type="text" name="mcname" 
				value="${mcname eq null?'商品名称搜索':mcname }"
				 onfocus="this.value='';"
        	 	style="border: #D3DBDE 1px solid; height: 32px; width: 150px;">
        		<input type="submit" value="搜索" style="border: #D3DBDE 1px solid; height: 32px; width: 60px;">
			</form>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>商品编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>商品名称</th>
        <th>商品数量</th>
        <th>商品价格</th>
        <th>商品小类</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        
        <c:forEach var="mc" items="${page.list }">
		        <tr>
			        <td><input name="" type="checkbox" value="" /></td>
			        <td>${mc.mcid }</td>
			        <td>${mc.mcname }</td>
			        <td>${mc.quantity }</td>
			        <td>${mc.price }</td>
			        <td>${mc.smalltypeid }</td>
			        <td>
			        	<a href="" class="tablelink">修改</a> 
			            <a href="" class="tablelink"> 删除</a>
			        </td>
		        </tr> 
        </c:forEach>
        </tbody>
    </table>
    
    </div>
    <div style="margin-bottom: 20px; margin-left: 5px;" >
    <!--
    	../ 当前目录上一级
    	../../  当前目录上一级上一级
      -->
    	<jsp:include page="../../BasePage.jsp"></jsp:include>
    	
    </div>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>