package com.hd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hd.model.Manager;
import com.hd.service.IManagerService;
import com.hd.service.impl.ManagerServiceImpl;

/**
 * Servlet implementation class BackLoginServlet
 */
@WebServlet("/BackLoginServlet")
public class BackLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IManagerService service = new ManagerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// ��ȡ�û��ύ���û���Ϣ
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// У��ʱ���¼�ɹ�
		Manager manager = service.login(userName, password);
		if(manager != null){
			// ��ʾ��¼�ɹ�
			// ����ǰ��¼���û���Ϣ���浽session��������
			session.setAttribute("BACKLOGINUSER", manager);
			request.getRequestDispatcher("back/main.jsp").forward(request, response);
		}else{
			// ��ʾ��¼ʧ��
			// ��session�������б���һ��������ʾ��Ϣ
			session.setAttribute("BACKLOGIN_MSG", "��¼ʧ��");
			response.sendRedirect("BackLogin.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
