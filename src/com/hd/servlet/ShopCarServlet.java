package com.hd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;

import com.hd.model.Mc;
import com.hd.service.IMcService;
import com.hd.service.impl.McServiceImpl;
import com.hd.util.ShopCar;
import com.hd.util.WebUtil;

/**
 * Servlet �����ﳵ��ص�Servlet
 */
@WebServlet("/ShopCarServlet")
public class ShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IMcService mcService = new McServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		// 3.���������Ʒ��ӵ����ﳵ��
		ShopCar car = ShopCar.getShopCar(request);
		
		if("clear".equals(task)){
			// ��ʾ��Ҫ��չ��ﳵ
			car.clear();
			response.sendRedirect("front/shop.jsp");
		}else if("delete".equals(task)){
			// �ӹ��ﳵ��ɾ��ĳ����Ʒ
			String mcid = request.getParameter("mcid");
			if(!WebUtil.isEmpty(mcid)){
				car.delete(WebUtil.parserInt(mcid));
				response.sendRedirect("front/shop.jsp");
			}
		}else if("update".equals(task)){
			// �޸Ĺ��ﳵ�й������Ʒ����
			String mcid = request.getParameter("mcid");
			String num = request.getParameter("num");
			// ���ù��ﳵ���޸ĵķ���
			car.update(WebUtil.parserInt(mcid), WebUtil.parserInt(num));
			response.sendRedirect("front/shop.jsp");
		}else{
			// 1.��ȡ������Ʒ�ı��
			String mcid = request.getParameter("mcid");
			if(!WebUtil.isEmpty(mcid)){
				// 2.���ݱ�Ų�ѯ������Ʒ����ϸ��Ϣ
				Mc mc = mcService.queryById(WebUtil.parserInt(mcid));
				
				car.add(mc);
				// 4.��������
				PrintWriter out = response.getWriter();
				out.write(car.getCount()+"");
				out.flush();
				out.close();
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
