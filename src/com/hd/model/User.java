package com.hd.model;

import java.sql.Date;

/**
 * JavaBean 前台用户
 * @author dpb
 *
 */
public class User {

	private int userid;
	private String username;
	private String password;
	private String truename;
	private String usersex;
	private Date birthday;
	private String email;
	private String phoneno;
	private String postcade;
	private String address;
	private Date regdate;
	private String lockstate;
	private Date lastaccess;
	private int login;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPostcade() {
		return postcade;
	}
	public void setPostcade(String postcade) {
		this.postcade = postcade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getLockstate() {
		return lockstate;
	}
	public void setLockstate(String lockstate) {
		this.lockstate = lockstate;
	}
	public Date getLastaccess() {
		return lastaccess;
	}
	public void setLastaccess(Date lastaccess) {
		this.lastaccess = lastaccess;
	}
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	
	
}
