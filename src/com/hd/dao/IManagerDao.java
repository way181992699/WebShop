package com.hd.dao;

import com.hd.model.Manager;

/**
 * Dao 管理员
 * @author dpb
 *
 */
public interface IManagerDao {

	/**
	 * 登录校验的方法
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 *    查询的信息，null 表示登录失败
	 */
	public Manager login(String userName,String password);
}
