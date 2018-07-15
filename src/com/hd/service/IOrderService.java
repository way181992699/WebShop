package com.hd.service;

import com.hd.model.Order;
import com.hd.util.BasePage;

/**
 * Service 订单
 * @author dpb
 *
 */
public interface IOrderService {
	/**
	 * 添加订单主表信息
	 * @param order 需要添加的信息
	 * @return
	 *    -1表示操作失败
	 *      其他值表示影响的行数
	 */
	public int add(Order order);
	
	/**
	 * 分页查询订单信息
	 * @param order
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public BasePage<Order> queryByPage(Order order,int currentPage,int pageSize);

	/**
	 * 根据id查询单条订单信息
	 * @param orderId 查询的条件
	 * @return
	 *    查询的结果
	 */
	public Order queryById(int orderId);
	
	
}
