package com.hd.service;

import com.hd.model.Manager;
/**
 * service ����Ա
 * @author dpb
 *
 */
public interface IManagerService {

	/**
	 * ��¼У��ķ���
	 * @param userName �û���
	 * @param password ����
	 * @return
	 *    ��ѯ����Ϣ��null ��ʾ��¼ʧ��
	 */
	public Manager login(String userName,String password);
}
