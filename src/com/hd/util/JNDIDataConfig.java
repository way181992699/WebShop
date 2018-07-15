package com.hd.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * JDNI获取数据连接
 * @author dpb
 *
 */
public class JNDIDataConfig {

	public static Connection getConnection(){
		//初始化查找命名空间
        Context ctx;
		try {
			ctx = new InitialContext();
			//参数java:/comp/env为固定路径   
	        Context envContext = (Context)ctx.lookup("java:/comp/env"); 
	        //参数jdbc/mysqlds为数据源和JNDI绑定的名字
	        DataSource ds = (DataSource) envContext.lookup("jdbc/oracleds"); 
	        return ds.getConnection(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         return null;

	}
}
