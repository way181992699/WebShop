package com.hd.dao;

import java.util.List;

import com.hd.model.OrderDetail;

/**
 * Dao 订单详情
 * @author dpb
 *
 */
public interface IOrderDetailDao {

	/**
	 * 用来添加订单详情信息
	 * @param detail 需要添加的数据
	 * @return
	 *   -1 表示操作失败
	 *   其他数值表示影响的行数
	 */
	public int add(OrderDetail detail);
	
	/**
	 * 根据订单编号查询关联的所有的订单详情信息
	 * @param order 订单编号
	 * @return
	 *    查询的结果
	 */
	public List<OrderDetail> queryByOrderId(int order);
}
