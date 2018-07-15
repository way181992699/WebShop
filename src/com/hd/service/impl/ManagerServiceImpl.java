package com.hd.service.impl;

import com.hd.dao.IManagerDao;
import com.hd.dao.impl.ManagerDaoImpl;
import com.hd.model.Manager;
import com.hd.service.IManagerService;

/**
 * service 实现类 管理员
 * @author dpb
 *
 */
public class ManagerServiceImpl implements IManagerService {

	IManagerDao dao = new ManagerDaoImpl();
	
	@Override
	public Manager login(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.login(userName, password);
	}

}
