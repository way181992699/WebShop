package com.hd.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
	/**
	 * java.util.Date 可以表示年月日 时分秒
	 * 		|-- java.sql.Date 只能够表示年月日
	 *      |-- java.sql.Timestamp 可以表示年月日时分秒及秒后的小数
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String d1 = "2012-01-01";
		// 1.时间类型的字符串转化为java.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d2 = sdf.parse(d1);
		System.out.println(d2);
		// 2.java.util.Date转化为java.sql.Date
		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		System.out.println(d3);
		java.sql.Timestamp d4= new java.sql.Timestamp(d2.getTime());
		System.out.println(d4);
	}
		
}
