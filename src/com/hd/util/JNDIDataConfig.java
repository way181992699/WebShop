package com.hd.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * JDNI��ȡ��������
 * @author dpb
 *
 */
public class JNDIDataConfig {

	public static Connection getConnection(){
		//��ʼ�����������ռ�
        Context ctx;
		try {
			ctx = new InitialContext();
			//����java:/comp/envΪ�̶�·��   
	        Context envContext = (Context)ctx.lookup("java:/comp/env"); 
	        //����jdbc/mysqldsΪ����Դ��JNDI�󶨵�����
	        DataSource ds = (DataSource) envContext.lookup("jdbc/oracleds"); 
	        return ds.getConnection(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         return null;

	}
}
