package com.hd.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
	/**
	 * java.util.Date ���Ա�ʾ������ ʱ����
	 * 		|-- java.sql.Date ֻ�ܹ���ʾ������
	 *      |-- java.sql.Timestamp ���Ա�ʾ������ʱ���뼰����С��
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String d1 = "2012-01-01";
		// 1.ʱ�����͵��ַ���ת��Ϊjava.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d2 = sdf.parse(d1);
		System.out.println(d2);
		// 2.java.util.Dateת��Ϊjava.sql.Date
		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		System.out.println(d3);
		java.sql.Timestamp d4= new java.sql.Timestamp(d2.getTime());
		System.out.println(d4);
	}
		
}
