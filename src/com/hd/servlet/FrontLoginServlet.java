package com.hd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hd.model.User;
import com.hd.service.IUserService;
import com.hd.service.impl.UserServiceImpl;

/**
 * Servlet ǰ̨��¼��servlet
 */
@WebServlet("/FrontLoginServlet")
public class FrontLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService service = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.�ж�У��ʱ����ȷ
		// ��ȡ���ɵ�У����
		HttpSession session = request.getSession();
		String task = request.getParameter("task");
		if("logout".equals(task)){
			session.invalidate();
			// ע������ת�ص�¼����
			response.sendRedirect("FrontLogin.jsp");
		}else{
			login(request, response, session);
		}
		
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String rand = (String) session.getAttribute("rand");
		// ��ȡ�û��ύ��У����
		String code = request.getParameter("Code");
		if(code .equals(rand)){
			//��ʾУ������ȷ
			// 1.��ȡǰ̨��¼�ύ������
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			// 2.У���¼
			User user = service.login(userName, password);
			// 3.�жϵ�¼�����ת����Ӧ�Ľ���
			if(user != null){
				// ��ʾ��¼�ɹ�
				// ��ǰ̨��ǰ��¼�û���Ϣ���浽Session��������
				session.setAttribute("USER", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				// ��ʾ��¼ʧ��
				session.setAttribute("FRONTLOGINMSG", "�˻���������");
				// ��ת�ص�¼����
				response.sendRedirect("FrontLogin.jsp");
			}
		}else{
			//У�������
			session.setAttribute("FRONTLOGINMSG", "У�������");
			// ��ת�ص�¼����
			response.sendRedirect("FrontLogin.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
