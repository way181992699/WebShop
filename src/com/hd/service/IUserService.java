package com.hd.service;

import com.hd.model.User;
/**
 * service ǰ̨�û�
 * @author dpb
 *
 */
public interface IUserService {
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
