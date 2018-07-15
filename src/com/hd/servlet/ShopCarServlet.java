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
 * Servlet 处理购物车相关的Servlet
 */
@WebServlet("/ShopCarServlet")
public class ShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IMcService mcService = new McServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		// 3.将购买的商品添加到购物车中
		ShopCar car = ShopCar.getShopCar(request);
		
		if("clear".equals(task)){
			// 表示需要清空购物车
			car.clear();
			response.sendRedirect("front/shop.jsp");
		}else if("delete".equals(task)){
			// 从购物车中删除某件商品
			String mcid = request.getParameter("mcid");
			if(!WebUtil.isEmpty(mcid)){
				car.delete(WebUtil.parserInt(mcid));
				response.sendRedirect("front/shop.jsp");
			}
		}else if("update".equals(task)){
			// 修改购物车中购买的商品数量
			String mcid = request.getParameter("mcid");
			String num = request.getParameter("num");
			// 调用购物车中修改的方法
			car.update(WebUtil.parserInt(mcid), WebUtil.parserInt(num));
			response.sendRedirect("front/shop.jsp");
		}else{
			// 1.获取购买商品的编号
			String mcid = request.getParameter("mcid");
			if(!WebUtil.isEmpty(mcid)){
				// 2.根据编号查询出改商品的详细信息
				Mc mc = mcService.queryById(WebUtil.parserInt(mcid));
				
				car.add(mc);
				// 4.方法总数
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
