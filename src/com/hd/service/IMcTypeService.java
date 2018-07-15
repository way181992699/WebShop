package com.hd.service;

import java.util.List;

import com.hd.model.McType;

/**
 * service  ��Ʒ���
 * @author dpb
 *
 */
public interface IMcTypeService {
	/**
	 * �����Ʒ��Ϣ
	 * @param type ���������Ҫ��ӵ����ݵ�McType����
	 * @return
	 * 		-1 ��ʾ����ʧ��
	 *      �������ֱ�ʾӰ�������
	 */
	public int add(McType type);
	
	/**
	 * ����idɾ����Ʒ��������
	 * @param id ��Ҫɾ�������ݵ�id
	 * @return
	 * 	   -1 ��ʾ����ʧ��
	 *     �������ֱ�ʾӰ�������
	 */
	public int delete(int id);
	
	/**
	 * ����id������Ʒ��������
	 * @param type ���������Ҫ���µ����ݼ�����
	 * @return
	 *    -1 ��ʾ����ʧ��
	 *    �������ֱ�ʾ����Ӱ�������
	 */
	public int update(McType type);
	
	/**
	 * ��ѯ���е���Ʒ�����Ϣ
	 * @return
	 *    ��ѯ������
	 */
	public List<McType> queryAll();
	
	/**
	 * ����id��ѯ��Ʒ�����Ϣ
	 * @param id ��Ҫ��ѯ������
	 * @return
	 *    ��ѯ������
	 */
	public McType queryById(int id);
	
	/**
	 * ��ѯ�����е���Ʒ���������
	 * @return
	 */
	public List<McType> queryFather();
	
	/**
	 * ���ݸ���id��ѯ���еĶ�Ӧ������
	 * @param id
	 * @return
	 */
	public List<McType> queryByFatherId(int id);
}
