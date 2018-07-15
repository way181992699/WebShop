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
 * Servlet 前台登录的servlet
 */
@WebServlet("/FrontLoginServlet")
public class FrontLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService service = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.判断校验时候正确
		// 获取生成的校验码
		HttpSession session = request.getSession();
		String task = request.getParameter("task");
		if("logout".equals(task)){
			session.invalidate();
			// 注销后跳转回登录界面
			response.sendRedirect("FrontLogin.jsp");
		}else{
			login(request, response, session);
		}
		
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String rand = (String) session.getAttribute("rand");
		// 获取用户提交的校验码
		String code = request.getParameter("Code");
		if(code .equals(rand)){
			//表示校验码正确
			// 1.获取前台登录提交的数据
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			// 2.校验登录
			User user = service.login(userName, password);
			// 3.判断登录结果跳转到对应的界面
			if(user != null){
				// 表示登录成功
				// 把前台当前登录用户信息保存到Session作用域中
				session.setAttribute("USER", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				// 表示登录失败
				session.setAttribute("FRONTLOGINMSG", "账户密码有误");
				// 跳转回登录界面
				response.sendRedirect("FrontLogin.jsp");
			}
		}else{
			//校验码错误
			session.setAttribute("FRONTLOGINMSG", "校验码错误");
			// 跳转回登录界面
			response.sendRedirect("FrontLogin.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
