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
 * Servlet ����
 */
@WebServlet("/front/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IOrderService service = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		HttpSession session = request.getSession();
		if("query".equals(task)){
			// ��ʾ��ѯ���еĶ���������Ϣ
			int currentPage = WebUtil.getCurrentPage(request, 0);
			int pageSize = WebUtil.getPageSize(request, 10);
			// ��ȡ��ǰ��¼�û����û���
			Object obj = session.getAttribute("USER");
			if(obj != null){
				User user = (User) obj;
				Order order = new Order();
				order.setUserid(user.getUserid());
				// ��ʾ�Ѿ���¼
				BasePage<Order> page = service.queryByPage(order, currentPage, pageSize);
				// ����ѯ�����ݷ�����������
				request.setAttribute("page", page);
				request.getRequestDispatcher("order/showOrder.jsp").forward(request, response);
			}else{
				// ��ʾû�е�¼
				response.sendRedirect("../FrontLogin.jsp");
			}
			/*// �ж�ʱ���в�ѯ���� Dao
			if(order != null){
				if(order.getUserid() > 0 ){
					// ��Ӳ�ѯ����
					whereSql.append(" and userid = ? ");
					// ���ռλ����Ӧ�Ĳ���
					list.add(order.getUserid());
				}
			}*/
		}else{
			add(request, response);
		}
		
		
		
	}

	/**
	 * �¶���
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.��ȡ���ύ������
		String paytype = request.getParameter("paytype");
		String receivedtype = request.getParameter("receivedtype");
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String phoneno = request.getParameter("phoneno");
		String email = request.getParameter("email");
		// ��ȡOrder����
		Order order  = new Order();
		// ��ȡ���ﳵ����
		HttpSession session = request.getSession();
		ShopCar car  = (ShopCar) session.getAttribute("SHOPCAR");
		User user = (User) session.getAttribute("USER");
		order.setUserid(user.getUserid()); // ��ǰ��¼�û����
		order.setAddress(address); // �ջ��˵�ַ
		// ���ﳵ�����������
		order.setAlltype(car.getCountType());
		order.setEmail(email);
		order.setPaytype(paytype); // ���ʽ
		order.setPhoneno(phoneno);
		order.setPostcode(postcode); // �ʱ�
		order.setQuantity(car.getCount()); // ������Ʒ������
		order.setReceivedtype(receivedtype); // �ʼķ�ʽ
		order.setTotalprice(car.getTotal());  // ��Ʒ�ܼ�
		order.setUsername(username); // �ռ�������
		List<OrderDetail> list = new ArrayList<>();
		for (Mc mc : car.getList()) {
			OrderDetail d = new OrderDetail();
			d.setMcid(mc.getMcid());
			d.setBuynum(mc.getShopNum());
			list.add(d);
		}
		// ������������ӵ�order��
		order.setList(list);
		// ��ȡService�������add����
		service.add(order);
		// ��ת����Ӧ�Ľ�����ת����Ա���Ľ���
		response.sendRedirect("member.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
