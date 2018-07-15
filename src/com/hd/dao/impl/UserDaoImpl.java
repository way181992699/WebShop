package com.hd.dao.impl;

import com.hd.dao.IUserDao;
import com.hd.model.User;
import com.hd.util.BaseDao;

public class UserDaoImpl extends BaseDao<User> implements IUserDao {

	private String sql;

	@Override
	public User login(String userName, String password) {
		sql =" select * from t_user where username = ? and password = ? ";
		return super.baseQueryById(sql, User.class, userName,password);
	}

}
