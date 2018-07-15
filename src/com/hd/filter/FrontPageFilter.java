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
 * Servlet Filter ��ǰ̨ҳ������ȫУ��
 */
@WebFilter("/front/order/*")
public class FrontPageFilter implements Filter {


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// �жϵ�ǰ�û�ʱ���¼�������¼��ô�Ź������û�е�¼��ô��ת��ǰ̨��¼����
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		HttpServletResponse res = (HttpServletResponse) response;
		Object obj = session.getAttribute("USER");
		if(obj != null){
			// ��ʾ�Ѿ���¼��
			chain.doFilter(request, response);
		}else{
			// ��ת�ص�¼����
			res.sendRedirect("../../FrontLogin.jsp");
		}
		
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
