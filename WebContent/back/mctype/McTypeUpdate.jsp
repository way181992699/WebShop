<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
		String basePath = request.getScheme()+"://"
		 +request.getServerName()+":"
		 +request.getServerPort()+path+"/";
	// http://localhost:8081/Day13_Shop/
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改商品类别</span></div>
    
    <form action="back/McTypeServlet?task=update&typeid=${type.typeid }" method="post">
	    <!-- 
	    	id:为了我们便于查找标记
	    	class:便于我们样式的使用
	    	name:给标记添加一个名称，便于数据的传输
	     -->
	    <ul class="forminfo">
	    <li>
	    	<label>类别名称</label>
	    		<input name="typename" value="${type.typename }"
	    		 type="text" class="dfinput" />
	    	<i></i>
	    	</li>
	    <li><label>父类别编号</label>  
	    
	
	    <div class="vocation">
	    <select class="select1" name="fatherid">
	    	<!-- 
	    	   <option selected="selected"></option>
	    	 -->
	    <option value="0">无</option>
	   		<c:forEach var="father" items="${list }">
	   			<option value="${father.typeid }"
	   			${father.typeid eq type.fatherid?'selected="selected"':'' }>${father.typename }</option>
	   		</c:forEach>
	    </select>
	    </div>
	    
	    </li>
	    <li><label>&nbsp;</label>
	    <input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
	    
    </form>
    </div>


<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>