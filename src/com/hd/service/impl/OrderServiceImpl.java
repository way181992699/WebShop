package com.hd.service.impl;

import com.hd.dao.IOrderDao;
import com.hd.dao.impl.OrderDaoImpl;
import com.hd.model.Order;
import com.hd.service.IOrderService;
import com.hd.util.BasePage;
/**
 * ctrl+shift+o 删除导入的多余的package
 * @author Administrator
 *
 */
public class OrderServiceImpl implements IOrderService {

	IOrderDao dao = new OrderDaoImpl();
	@Override
	public int add(Order order) {
		// TODO Auto-generated method stub
		return dao.add(order);
	}

	@Override
	public BasePage<Order> queryByPage(Order order, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return dao.queryByPage(order, currentPage, pageSize);
	}

	@Override
	public Order queryById(int orderId) {
		// TODO Auto-generated method stub
		return dao.queryById(orderId);
	}

}
