package com.hd.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hd.model.Mc;
import com.hd.model.Order;
import com.hd.model.OrderDetail;
import com.hd.model.User;
import com.hd.service.IOrderService;
import com.hd.service.impl.OrderServiceImpl;
import com.hd.util.BasePage;
import com.hd.util.ShopCar;
import com.hd.util.WebUtil;

/**
 * Servlet 订单
 */
@WebServlet("/front/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IOrderService service = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		HttpSession session = request.getSession();
		if("query".equals(task)){
			// 表示查询所有的订单主表信息
			int currentPage = WebUtil.getCurrentPage(request, 0);
			int pageSize = WebUtil.getPageSize(request, 10);
			// 获取当前登录用户的用户名
			Object obj = session.getAttribute("USER");
			if(obj != null){
				User user = (User) obj;
				Order order = new Order();
				order.setUserid(user.getUserid());
				// 表示已经登录
				BasePage<Order> page = service.queryByPage(order, currentPage, pageSize);
				// 将查询的数据放入作用域中
				request.setAttribute("page", page);
				request.getRequestDispatcher("order/showOrder.jsp").forward(request, response);
			}else{
				// 表示没有登录
				response.sendRedirect("../FrontLogin.jsp");
			}
			/*// 判断时候有查询条件 Dao
			if(order != null){
				if(order.getUserid() > 0 ){
					// 添加查询条件
					whereSql.append(" and userid = ? ");
					// 添加占位符对应的参数
					list.add(order.getUserid());
				}
			}*/
		}else{
			add(request, response);
		}
		
		
		
	}

	/**
	 * 下订单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.获取表单提交的数据
		String paytype = request.getParameter("paytype");
		String receivedtype = request.getParameter("receivedtype");
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String phoneno = request.getParameter("phoneno");
		String email = request.getParameter("email");
		// 获取Order对象
		Order order  = new Order();
		// 获取购物车对象
		HttpSession session = request.getSession();
		ShopCar car  = (ShopCar) session.getAttribute("SHOPCAR");
		User user = (User) session.getAttribute("USER");
		order.setUserid(user.getUserid()); // 当前登录用户编号
		order.setAddress(address); // 收货人地址
		// 购物车中总类别数量
		order.setAlltype(car.getCountType());
		order.setEmail(email);
		order.setPaytype(paytype); // 付款方式
		order.setPhoneno(phoneno);
		order.setPostcode(postcode); // 邮编
		order.setQuantity(car.getCount()); // 购买商品的总数
		order.setReceivedtype(receivedtype); // 邮寄方式
		order.setTotalprice(car.getTotal());  // 商品总价
		order.setUsername(username); // 收件人姓名
		List<OrderDetail> list = new ArrayList<>();
		for (Mc mc : car.getList()) {
			OrderDetail d = new OrderDetail();
			d.setMcid(mc.getMcid());
			d.setBuynum(mc.getShopNum());
			list.add(d);
		}
		// 将订单详情添加到order中
		order.setList(list);
		// 获取Service对象调用add方法
		service.add(order);
		// 跳转到对应的界面跳转到会员中心界面
		response.sendRedirect("member.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
