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
		// 获取用户提交的用户信息
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// 校验时候登录成功
		Manager manager = service.login(userName, password);
		if(manager != null){
			// 表示登录成功
			// 将当前登录的用户信息保存到session作用域中
			session.setAttribute("BACKLOGINUSER", manager);
			request.getRequestDispatcher("back/main.jsp").forward(request, response);
		}else{
			// 表示登录失败
			// 给session作用域中保存一个错误提示信息
			session.setAttribute("BACKLOGIN_MSG", "登录失败");
			response.sendRedirect("BackLogin.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
