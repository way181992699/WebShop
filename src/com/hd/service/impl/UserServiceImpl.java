package com.hd.service.impl;

import com.hd.dao.IUserDao;
import com.hd.dao.impl.UserDaoImpl;
import com.hd.model.User;
import com.hd.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	IUserDao dao = new UserDaoImpl();
	
	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.login(userName, password);
	}

}
