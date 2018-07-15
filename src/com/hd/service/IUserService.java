package com.hd.service;

import com.hd.model.User;
/**
 * service 前台用户
 * @author dpb
 *
 */
public interface IUserService {
	/**
	 * 校验前台用户时候登录成功
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 *    空表示登录失败
	 *    
	 */
	public User login(String userName,String password);
}
