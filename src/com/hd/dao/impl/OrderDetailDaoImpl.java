package com.hd.dao.impl;

import java.util.List;

import com.hd.dao.IOrderDetailDao;
import com.hd.model.OrderDetail;
import com.hd.util.BaseDao;

public class OrderDetailDaoImpl extends BaseDao<OrderDetail> implements IOrderDetailDao {

	String sql ;
	@Override
	public int add(OrderDetail detail) {
		sql = " insert into T_ORDERDETAIL(DETAILID,ORDERID,MCID,BUYNUM)values(seq_t_orderdetail.nextval,?,?,?)";
		return super.baseUpdate(sql, detail.getOrderid(),detail.getMcid(),detail.getBuynum());
	}

	@Override
	public List<OrderDetail> queryByOrderId(int orderId) {
		sql = " select * from t_orderdetail where orderid = ? ";
		return super.baseQuery(sql, OrderDetail.class, orderId);
	}

}
