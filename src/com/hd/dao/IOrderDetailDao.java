package com.hd.dao;

import java.util.List;

import com.hd.model.OrderDetail;

/**
 * Dao ��������
 * @author dpb
 *
 */
public interface IOrderDetailDao {

	/**
	 * ������Ӷ���������Ϣ
	 * @param detail ��Ҫ��ӵ�����
	 * @return
	 *   -1 ��ʾ����ʧ��
	 *   ������ֵ��ʾӰ�������
	 */
	public int add(OrderDetail detail);
	
	/**
	 * ���ݶ�����Ų�ѯ���������еĶ���������Ϣ
	 * @param order �������
	 * @return
	 *    ��ѯ�Ľ��
	 */
	public List<OrderDetail> queryByOrderId(int order);
}
