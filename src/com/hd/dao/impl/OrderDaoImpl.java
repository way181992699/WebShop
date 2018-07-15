package com.hd.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hd.dao.IOrderDao;
import com.hd.dao.IOrderDetailDao;
import com.hd.model.Order;
import com.hd.model.OrderDetail;
import com.hd.util.BaseDao;
import com.hd.util.BasePage;

public class OrderDaoImpl extends BaseDao<Order> implements IOrderDao {

	private String sql;
	
	IOrderDetailDao detailDao = new OrderDetailDaoImpl();

	@Override
	public int add(Order order) {
		String orderId = createOrderId();
		sql = "insert into T_ORDERS(ORDERID,USERID,QUANTITY,ALLTYPE,TOTALPRICE,PAYTYPE,RECEIVEDTYPE,USERNAME,ADDRESS,POSTCODE,PHONENO,EMAIL,ORDERDATE)values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		// ���涩���������Ϣ
		super.baseUpdate(sql, orderId,order.getUserid(),order.getQuantity(),order.getAlltype(),order.getTotalprice(),order.getPaytype()
				,order.getReceivedtype(),order.getUsername(),order.getAddress(),order.getPostcode(),order.getPhoneno(),order.getEmail());
		// ���涩���������Ϣ
		for(OrderDetail detail:order.getList()){
			// ��������ű��浽������
			detail.setOrderid(orderId);
			// ����OrderDetailDao�еķ������
			detailDao.add(detail);
		}
		return 0;
	}

	/**
	 * ����һ���������
	 * @return
	 */
	private  String createOrderId() {
		return new Date().getTime()+"";
	}
	
	

	@Override
	public BasePage<Order> queryByPage(Order order, int currentPage, int pageSize) {
		StringBuilder countSql = new StringBuilder("select count(1) from T_ORDERS where 1=1 ");
		StringBuilder querySql = new StringBuilder(" select * from T_ORDERS where 1=1 ");
		StringBuilder whereSql = new StringBuilder();
		StringBuilder otherSql = new StringBuilder();
		List<Object> list = new ArrayList<>();
		// �ж�ʱ���в�ѯ����
		if(order != null){
			if(order.getUserid() > 0 ){
				// ��Ӳ�ѯ����
				whereSql.append(" and userid = ? ");
				// ���ռλ����Ӧ�Ĳ���
				list.add(order.getUserid());
			}
		}
		return super.queryByPage(countSql, querySql, whereSql, otherSql
				, pageSize, currentPage, Order.class, list);
	}

	@Override
	public Order queryById(int orderId) {
		sql = " select * from T_ORDERS where orderid = ? ";
		return super.baseQueryById(sql, Order.class, orderId);
	}

}
