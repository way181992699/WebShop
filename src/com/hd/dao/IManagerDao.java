package com.hd.dao;

import com.hd.model.Manager;

/**
 * Dao ����Ա
 * @author dpb
 *
 */
public interface IManagerDao {

	/**
	 * ��¼У��ķ���
	 * @param userName �û���
	 * @param password ����
	 * @return
	 *    ��ѯ����Ϣ��null ��ʾ��¼ʧ��
	 */
	public Manager login(String userName,String password);
}
