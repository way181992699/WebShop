package com.hd.dao;

import com.hd.model.User;

/**
 * Dao ǰ̨�û�
 * @author dpb
 *
 */
public interface IUserDao {

	/**
	 * У��ǰ̨�û�ʱ���¼�ɹ�
	 * @param userName �û���
	 * @param password ����
	 * @return
	 *    �ձ�ʾ��¼ʧ��
	 *    
	 */
	public User login(String userName,String password);
}
