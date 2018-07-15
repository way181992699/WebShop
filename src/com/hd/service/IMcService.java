package com.hd.service;

import java.util.List;

import com.hd.model.Mc;
import com.hd.util.BasePage;

/**
 * Service ��Ʒ��Ϣ
 * @author dpb
 *
 */
public interface IMcService {
	/**
	 * �����Ʒ��Ϣ
	 * @param mc ��Ҫ��ӵ�����
	 * @return
	 * 	 -1 ��ʾ����ʧ��
	 *   ������ʾӰ�������
	 */
	public int add(Mc mc);
	
	/**
	 * ������Ʒ��Ϣ
	 * @param mc ��Ҫ���µ����ݺ�����
	 * @return
	 * 	 -1 ��ʾ����ʧ��
	 *   ������ʾӰ�������
	 */
	public int update(Mc mc);
	
	/**
	 * ����idɾ������
	 * @param id ��Ҫɾ��������
	 * @return
	 * 	 -1 ��ʾ����ʧ��
	 *   ������ʾӰ�������
	 */
	public int delete(int id);
	
	/**
	 * ��ѯ���е���Ʒ��Ϣ
	 * @return
	 *   ��ѯ�Ľ��
	 */
	public List<Mc> queryAll();
	
	/**
	 * ����id��ѯ��Ʒ��Ϣ
	 * @param id ��ѯ������
	 * @return
	 *   ��ѯ�Ľ��
	 */
	public Mc queryById(int id);
	
	/**
	 * ���ݷ�ҳ������ѯ����
	 * @param mc ��ѯ������
	 * @param currentPage ��ѯ��ҳ��
	 * @param pageSize ÿҳ��ʾ������
	 * @return
	 *    ��ѯ�Ľ��
	 */
	public BasePage<Mc> queryPage(Mc mc,int currentPage,int pageSize);

}
