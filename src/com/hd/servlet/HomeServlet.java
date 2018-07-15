package com.hd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hd.model.Mc;
import com.hd.model.McType;
import com.hd.service.IMcService;
import com.hd.service.IMcTypeService;
import com.hd.service.impl.McServiceImpl;
import com.hd.service.impl.McTypeServiceImpl;
import com.hd.util.BasePage;
import com.hd.util.WebUtil;

/**
 * Servlet 电子商城首页
 */
@WebServlet("/front/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IMcTypeService typeService = new McTypeServiceImpl();
	IMcService mcService = new McServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.查询出所有的商品类别的信息
		List<McType> typeList = typeService.queryAll();
		// 2.分页查询出相关的商品信息的数据
		//   分页jsp页面处理1.分页条目 2.分页的form表单
		int currentPage = WebUtil.getCurrentPage(request, 0);
		int pageSize = WebUtil.getPageSize(request, 3);
		// 获取查询条件
		String mcName = request.getParameter("key");
		Mc mc = new Mc();
		if(!WebUtil.isEmpty(mcName)){
			mc.setMcname(mcName);
		}
		BasePage<Mc> page = mcService.queryPage(mc, currentPage, pageSize);
		// 3.将查询的数据放入作用域中
		request.setAttribute("typeList", typeList);
		request.setAttribute("page", page);
		request.setAttribute("mcname", mcName);
		// 4.跳转到home界面
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
