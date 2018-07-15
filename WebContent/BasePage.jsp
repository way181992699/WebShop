<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div style="margin-top: 7px;">
		每页显示<input style="width: 40px;"type="text" value="${page.pageSize }"
		 onblur="changePageSize(this.value);">条
		<input type="button" value="首页" onclick="beginPage();">
		<%-- <c:if test="${currentPage eq 0 }">
		<!-- 不让点击上一页 -->
			<input type="button" value="上一页" onclick="frontPage();" disabled="disabled">
		</c:if>
		
		<c:if test="${currentPage ne 0 }">
		<!-- 让点击上一页 -->
			<input type="button" value="上一页" onclick="frontPage();">
		</c:if> --%>
		<input type="button" ${page.currentPage eq 0?'disabled="disabled"':'' }
			 value="上一页" onclick="frontPage();">
		<input type="button" ${page.currentPage eq page.total?'disabled="disabled"':'' }
		value="下一页" onclick="nextPage();">
		<input type="button" value="尾页" onclick="endPage();">
		<!-- 
			点击下一页  将 currentPage+1 并提交表单
		-->
		总共有 <font color="red">${page.total }</font> 页，
		当前是第 <font color="red">${page.currentPage}</font>页 
		总共有<font color="red">${page.count }</font>条记录
		跳转到<input style="width: 40px;" value="${page.currentPage }"
		 type="text" onblur="goPage(this.value)" >页
		跳转到 <select onchange="goPage(this.value);">
			<c:forEach var="i" begin="0" end="${page.total }">
			   <option value="${i }" ${i eq page.currentPage?'selected="selected"':'' }>${i+1 }</option>
			</c:forEach>
		</select> 页
	</div>
	
	<script type="text/javascript">
		// 获取首页数据
		function beginPage(){
			// 1.将currentPage+1
			document.getElementById("currentPage").value=0;
			// 2.将表单数据提交
			document.getElementById("pageForm").submit();
		}
		// 获取上一页
		function frontPage(){
			// 1.将currentPage+1
			document.getElementById("currentPage").value=${page.currentPage-1};
			// 2.将表单数据提交
			document.getElementById("pageForm").submit();
		}
	
		// 获取下一页的数据
		function nextPage(){
			// 1.将currentPage+1
			document.getElementById("currentPage").value=${page.currentPage+1};
			// 2.将表单数据提交
			document.getElementById("pageForm").submit();
		}
		// 获取尾页数据
		function endPage(){
			// 1.将currentPage+1
			document.getElementById("currentPage").value=${page.total};
			// 2.将表单数据提交
			document.getElementById("pageForm").submit();
		}
	
		// 跳转到指定的页数
		function goPage(page){
			// 1.将currentPage+1
			document.getElementById("currentPage").value=page;
			// 2.将表单数据提交
			document.getElementById("pageForm").submit();
		}
		// 改变每页显示的条数，同时将当前页置为首页
		function changePageSize(pageSize){
			// 1.将currentPage 改为0
			document.getElementById("currentPage").value=0;
			// 2.修改每页显示的条数
			document.getElementById("pageSize").value = pageSize;
			// 3.将表单数据提交
			document.getElementById("pageForm").submit();
		}
	</script>
