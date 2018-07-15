package com.hd.dao;

import com.hd.model.Order;
import com.hd.util.BasePage;

/**
 * Dao ��������
 * @author dpb
 *
 */
public interface IOrderDao {

	/**
	 * ���Ӷ���������Ϣ
	 * @param order ��Ҫ���ӵ���Ϣ
	 * @return
	 *    -1��ʾ����ʧ��
	 *      ����ֵ��ʾӰ�������
	 */
	public int add(Order order);
	
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param order
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public BasePage<Order> queryByPage(Order order,int currentPage,int pageSize);

	/**
	 * ����id��ѯ����������Ϣ
	 * @param orderId ��ѯ������
	 * @return
	 *    ��ѯ�Ľ��
	 */
	public Order queryById(int orderId);
	
	
}