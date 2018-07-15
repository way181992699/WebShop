package com.hd.dao.impl;

import com.hd.dao.IManagerDao;
import com.hd.model.Manager;
import com.hd.util.BaseDao;

public class ManagerDaoImpl extends BaseDao<Manager> implements IManagerDao{

	private String sql;

	@Override
	public Manager login(String userName, String password) {
		sql = " select * from t_manager where musername=? and mpassword=? ";
		return super.baseQueryById(sql, Manager.class, userName,password);
	}

}
