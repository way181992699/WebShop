<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="width:100%;background-color:#FFFAD0;">
<div id="header">
   <div id="h_left">
     <span>您好 <font color='red'><b>${USER.truename}</b></font>，欢迎来到XX店铺！
       ${USER eq null? '<a href="FrontLogin.jsp">请登录</a>':'<a href="FrontLoginServlet?task=logout">注销</a>'}
       | <a href="#">免费注册</a>
     </span>
   </div>
   <div id="h_right">
      <ul>
      <li><a href="#">我的订单</a></li>
       <li><a href="#">我的一号店</a></li>
        <li><a href="#">帮助中心</a></li>
         <li><a href="#">联系客服</a></li>
          <li><a href="#">加入收藏</a></li>
           <li class="u_last1"><a href="#">服务热线:</a></li>
            <li class="u_last2" >400-8888-666</li>
      
      </ul>
   </div>
</div>
</div>
<div id="logo_nav">
   <ul>
   		<%-- <jsp:include page="top.jsp">
				<jsp:param value="0" name="flag"/>
			</jsp:include> 
			
			int a = 2;
			// X?Y:Z
			boolean b = a==1?true:false;
			if(a == 1){
				b = true;
			}else{
				b = false;
			}
		--%>
   		
   		<li ${param.flag eq '0'?'class="nav_cur"':'' }><a href="index.jsp">首页</a></li>
        <li><a href="#">积分兑换</a></li>
        <li ${param.flag eq '2'?'class="nav_cur"':'' }><a href="front/member.jsp">会员中心</a></li>
        <li><a href="#">查看订单</a></li>
        <li ${param.flag eq '4'?'class="nav_cur"':'' }><a href="front/shop.jsp">购物车</a></li>
   	<%-- <%
   		String flag = request.getParameter("flag");
   		if("0".equals(flag)){
   			%>
   			<li class="nav_cur"><a href="home.jsp">首页</a></li>
   			<% 
   		}else{
   			%>
   			<li ><a href="home.jsp">首页</a></li>
   			<% 
   		}
   	%>
     
     <li><a href="#">积分兑换</a></li>
     <%
     if("2".equals(flag)){
			%>
			<li class="nav_cur"><a href="member.jsp">会员中心</a></li>
			<% 
		}else{
			%>
			<li ><a href="member.jsp">会员中心</a></li>
			<% 
		}
     %>
    
      <li><a href="#">查看订单</a></li> --%>
   
   </ul>

</div>
<div style="width:100%;background-color:#157128;">
<div id="seacher">
    <div id="sc_left">  
          <div id="sc_left_p1"> 
              <a href="#">所有商品分类</a>
         
           </div>
          <div  id="sc_left_p2">
          <form action="front/HomeServlet" id="pageForm" method="post">
				<input type="hidden" value="${page.currentPage }" id="currentPage" name="currentPage">
				<input type="hidden" value="${page.pageSize }" id="pageSize" name="pageSize">
				<input class="sc_keytext" value="${mcname }" style="height:30px; " type="text" name="key"/>
             	 <input type="submit" style="background:url(img/btn_search.jpg) no-repeat; width:85px; height:34px; border:0px;" value=" "/> 
          
			</form>
           
             
         </div>
         <div id="sc_left_p3">
            <ul>
              <li> <h3>热门搜索：</h3></li>
              <li><a href="#">贝玲妃</a></li>
               <li><a href="#">SKII</a></li>
                <li><a href="#">阿芙</a></li>
            </ul>
         </div>
    </div>
     <div id="sc_right">
        <ul>
          <li class="sc_rgt01"> <a href="#">购物车：
          <font id="shopCount">${SHOPCAR.count eq null ?'0':SHOPCAR.count}</font>件
          </a></li>
          <li  class="sc_rgt02"><a href="#">去结算>></a></li>
        </ul>
    </div>
</div>
</div>
<div id="welcome">
   <marquee >节日大促销</marquee>
</div>
