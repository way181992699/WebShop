package com.hd.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter 对前台页面做安全校验
 */
@WebFilter("/front/order/*")
public class FrontPageFilter implements Filter {


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 判断当前用户时候登录，如果登录那么放过，如果没有登录那么跳转回前台登录界面
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		HttpServletResponse res = (HttpServletResponse) response;
		Object obj = session.getAttribute("USER");
		if(obj != null){
			// 表示已经登录了
			chain.doFilter(request, response);
		}else{
			// 跳转回登录界面
			res.sendRedirect("../../FrontLogin.jsp");
		}
		
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
