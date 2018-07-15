package com.hd.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0���ӳ�
 * ���ݿ�������Ϣ�����࣬����������ȫ�ֵľ�̬�������ڴ�����ݿ�������Ϣ
 * @author Administrator
 *
 */
public class DataSourceConfig {
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "j1610";
	static String password = "j1610";
	
	
	/**
	 * ����Դ
	 */
	private static DataSource dataSource; 
	
	/**
	 * ��ȡ����Դ�������ӳض���
	 * @return Java.sql.DataSource
	 */
	public static synchronized DataSource getDataSource(){
		if(dataSource == null){
			initialization();
		}
		return dataSource;
	}
	
	/**
	 * ��ʼ�����ݿ����ӳ�
	 */
	public static void initialization(){
		if(dataSource != null){
			( (ComboPooledDataSource)dataSource).close();
		}
		
		ComboPooledDataSource tempDataSource = new ComboPooledDataSource();
		try {
			tempDataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			tempDataSource.setJdbcUrl(url);
			tempDataSource.setUser(user);
			tempDataSource.setPassword(password);
			tempDataSource.setCheckoutTimeout(7000);//���ó�ʱʱ�� 
			dataSource = tempDataSource;
			
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		DataSource dataSource = DataSourceConfig.getDataSource();
		Connection conn;
		try {
			conn = dataSource.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
