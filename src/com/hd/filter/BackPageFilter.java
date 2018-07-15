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
 * Servlet Filter ��̨ҳ�氲ȫУ��
 */
@WebFilter("/back/*")
public class BackPageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BackPageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// �жϵ�ǰʱ���ǵ�¼״̬������ǵĻ���ô�Ź���������ת�ص�¼����
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("BACKLOGINUSER");
		if(obj != null){
			// ��ʾ�Ѿ���¼ �Ź�
			chain.doFilter(request, response);
		}else{
			// û�е�¼����ת����¼����
			session.setAttribute("BACKLOGIN_MSG", "���ȵ�¼");
			res.sendRedirect("../BackLogin.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
