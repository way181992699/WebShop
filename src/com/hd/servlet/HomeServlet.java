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
 * Servlet �����̳���ҳ
 */
@WebServlet("/front/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IMcTypeService typeService = new McTypeServiceImpl();
	IMcService mcService = new McServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.��ѯ�����е���Ʒ������Ϣ
		List<McType> typeList = typeService.queryAll();
		// 2.��ҳ��ѯ����ص���Ʒ��Ϣ������
		//   ��ҳjspҳ�洦��1.��ҳ��Ŀ 2.��ҳ��form��
		int currentPage = WebUtil.getCurrentPage(request, 0);
		int pageSize = WebUtil.getPageSize(request, 3);
		// ��ȡ��ѯ����
		String mcName = request.getParameter("key");
		Mc mc = new Mc();
		if(!WebUtil.isEmpty(mcName)){
			mc.setMcname(mcName);
		}
		BasePage<Mc> page = mcService.queryPage(mc, currentPage, pageSize);
		// 3.����ѯ�����ݷ�����������
		request.setAttribute("typeList", typeList);
		request.setAttribute("page", page);
		request.setAttribute("mcname", mcName);
		// 4.��ת��home����
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
