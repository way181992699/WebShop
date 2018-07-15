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
<body onload="getBigType();">
	<script type="text/javascript">
		function getBigType(){
			//alert("1111");
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.open("GET","back/McTypeServlet?task=ajaxFather",true);
			xmlhttp.send();
			// 获取响应的数据
			xmlhttp.onreadystatechange = function(){
				if(xmlhttp.readyState=='4' && xmlhttp.status=='200'){
					var res = eval(xmlhttp.responseText);
					var father = document.getElementById("fatherid");
					father.length=0;
					for(var i=0;i<res.length;i++){
						var f = res[i];
						//alert(f.typeid+" "+f.typename);
						var opt = document.createElement("option");
						opt.value = f.typeid;
						opt.innerHTML=f.typename;
						father.appendChild(opt);
					}
				}
			}
		}
		
		function getSmallType(id){
			// 1.获取XMLHttpRequest对象
			var xmlhttp = new XMLHttpRequest();
			// 2.提交请求
			xmlhttp.open("GET","back/McTypeServlet?task=ajaxSmall&id="+id,true);
			xmlhttp.send();
			// 3.获取响应的数据
			xmlhttp.onreadystatechange = function(){
				if(xmlhttp.readyState == '4' && xmlhttp.status=='200'){
					var res = eval(xmlhttp.responseText);
					var small = document.getElementById("smallId");
					small.length = 0 ;
					for(var i = 0 ; i < res.length; i ++){
						var s = res[i];
						var opt = document.createElement("option");
						opt.value=s.typeid;
						opt.innerHTML=s.typename;
						small.appendChild(opt);
					}
				}
			}
		}
	</script>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>添加商品信息</span></div>
    
    <form action="back/McServlet?task=add" method="post" enctype="multipart/form-data">
	    
	    <ul class="forminfo">
	    <li>
	    	<label>商品名称</label>
	    		<input name="mcname" type="text" class="dfinput" />
	    	<i></i>
	    </li>
	    
	    <li>
	    	<label>商品价格</label>
	    		<input name="price" type="text" class="dfinput" />
	    	<i></i>
	    </li>
	    
	    <li>
	    	<label>商品数量</label>
	    		<input name="quantity" type="text" class="dfinput" />
	    	<i></i>
	    </li>
	    <li>
	    	<label>是否缺货</label>
	    		<input name="flag" type="radio" value="1" /> 缺
	    		<input name="flag" type="radio" value="0" checked="checked"/> 否
	    	<i></i>
	    </li>
	    
	    
	    <li>
	    	<label>商品图片</label>
	    		<input name="pic" type="file" />
	    	<i></i>
	    </li>
	    
	    <li>
	    	<label>商品大类</label>  
		    <div class="vocation">
		    <select class="select1" onchange="getSmallType(this.value);"
		     name="fatherid" id="fatherid">
		    	<option value="0">无</option>
		    </select>
		    </div>
	    </li>
	    
	    <li>
	    	<label>商品小类</label>  
		    <div class="vocation">
		    <select class="select1" name="smallTypeId" id="smallId">
		    	<option value="0">无</option>
		    </select>
		    </div>
	    </li>
	    
	    <li>
	    	<label>商品描述</label>  
		    <div class="vocation">
		    	<textarea name="mcdecx" rows="6" cols="49" style="border:#D3DBDE 1px solid; ">
		    	</textarea>
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