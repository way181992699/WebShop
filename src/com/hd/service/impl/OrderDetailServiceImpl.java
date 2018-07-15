package com.hd.service.impl;

import java.util.List;

import com.hd.dao.IOrderDetailDao;
import com.hd.dao.impl.OrderDetailDaoImpl;
import com.hd.model.OrderDetail;
import com.hd.service.IOrderDetailService;

public class OrderDetailServiceImpl implements IOrderDetailService {

	IOrderDetailDao dao = new OrderDetailDaoImpl();
	
	@Override
	public int add(OrderDetail detail) {
		// TODO Auto-generated method stub
		return dao.add(detail);
	}

	@Override
	public List<OrderDetail> queryByOrderId(int order) {
		// TODO Auto-generated method stub
		return dao.queryByOrderId(order);
	}

}
