package com.hd.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * ���ݿ�����Ĺ�����
 * @author dpb
 * @param <T>
 *
 */
public class BaseDao<T> {

	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;

	/**
	 * ���ݿ���ӣ��޸ģ�ɾ���Ĺ�������
	 * @param sql ��Ҫִ�е�sql���
	 * @param objs �ɱ�Ĳ����б�(����) 
	 * 			        �ò���ֻ�ܷ������βε����һ��
	 * 			   sql�е�ռλ����Ӧ�Ĳ���
	 * @return
	 * 		-1 ��ʾִ�г���
	 * 		����ֵ ��ʾӰ�������
	 */
	public static int baseUpdate(String sql,Object ... objs){
		// ��ȡ���ݿ������ͨ��
		 conn = DBUtil.getConnection();
		// ͨ�^JNDI�ķ�ʽ��ȥ����ͨ��
//		conn = JNDIDataConfig.getConnection();
		// ����sql���
		// ִ��sql ���
		try {
			// ͨ��c3p0��ȡ���ݿ�����ͨ��
			//conn = DataSourceConfig.getDataSource().getConnection();
			ps = conn.prepareStatement(sql);
			// ��sql����е�ռλ�����и�ֵ
			if(objs != null){
				// ���������б��ռλ�����и�ֵ
				for(int i = 0 ; i < objs.length ; i++){
					ps.setObject(i+1, objs[i]);
				}	
			}
			// ִ��sql��䷵��Ӱ�������
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			// �ر���Դ
			DBUtil.close(conn, ps);
		}
		return -1;
	}
	
	/**
	 * ��ѯ��ṹ�����������ļ�¼��
	 * @param sql ��Ҫִ�е�sql���
	 * @param objs sql����ж�Ӧ��ռλ����Ӧ�Ĳ���
	 * @return
	 * 		  -1 ��ʾִ�г���
	 *        ����ֵ ��ʾ��¼������
	 */
	public static int baseQueryForCount(String sql,Object ... objs){
		 conn = DBUtil.getConnection();
		// ͨ�^JNDI�ķ�ʽ��ȥ����ͨ��
//		conn = JNDIDataConfig.getConnection();
		try {
			// ͨ��c3p0��ȡ���ݿ�����ͨ��
			//conn = DataSourceConfig.getDataSource().getConnection();
			ps = conn.prepareStatement(sql);
			// ��ռλ�����и�ֵ
			if(objs != null){
				for(int i = 0 ; i < objs.length ; i++){
					ps.setObject(i+1, objs[i]);
				}
			}
			// ��ʾ��ִ��sql���
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			// �ر���Դ
			DBUtil.close(conn, ps, rs);
		}
		return -1;
	}
	
	/**
	 * ��ѯ������¼�������ض�Ӧ�Ķ���
	 * @param sql ��Ҫִ�е�sql���
	 * @param cls ���ض����Ӧ�������
	 * @param objs sql����ж�Ӧ��ռλ���Ĳ���
	 * @return
	 * 		���ط�װ�в�ѯ��¼�Ķ���
	 */
	public static <T> T baseQueryById(String sql,Class cls,Object ... objs){
		// ��ȡ���ݿ������ͨ��
		 conn = DBUtil.getConnection();
		// ͨ�^JNDI�ķ�ʽ��ȥ����ͨ��
//		conn = JNDIDataConfig.getConnection();
		try {
			// ͨ��c3p0��ȡ���ݿ�����ͨ��
			//conn = DataSourceConfig.getDataSource().getConnection();
			ps = conn.prepareStatement(sql);
			// ��ռλ�����и�ֵ
			if(objs != null){
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			// ִ��sql���
			rs = ps.executeQuery();
			// Ԫ����
			ResultSetMetaData md = rs.getMetaData();
			int rowCount = md.getColumnCount();
			//System.out.println("�ܹ��ж����У�"+rowCount);
			if(rs.next()){
				// 2. ��ȡ��װ���ݵĶ�Ӧ�Ķ���
				Object obj = cls.newInstance();
				//System.out.println(obj.getClass());
				// 1. �����м�¼�е�ÿһ���ֶμ���Ӧ��ֵȡ������
				for (int i = 0; i < rowCount; i++) {
					String name = md.getColumnLabel(i+1).toLowerCase();//id name sex
					Object value = rs.getObject(name);//1  ����  ��    id=1   name=����
					// �����ѯ���ֶε�ֵΪ�գ���ô��û�б�Ҫ���ո�ֵ�������������
					if(value == null){
						continue;
					}
					//System.out.println(name+":"+value+"���ͣ�"+value.getClass());
					// System.out.println(name+":"+value);
					// 3. ����ѯ���ֶε�ֵ���浽��Ӧ�Ķ���ĳ�Ա����(����)��
					// �ж���������Ƿ���ڱ����е��ֶζ�Ӧ�ĳ�Ա����
					if(hasField(cls, name)){
						// ���ݲ�ѯ���ֶε����ƻ�ȡ������ж�Ӧ�ĳ�Ա����
						Field field = cls.getDeclaredField(name);
						//System.out.println(field.getName());
						// �����˽�г�Ա������ֵ
						field.setAccessible(true);
						if(value instanceof BigDecimal){
							// value ����������Ҳ������С��
							BigDecimal bigValue = (BigDecimal) value;
							// �жϳ�Ա������ʲô���͵�
							if(field.getType().getName().equals("int")){
								// ��ֵ��������Ķ���ĳ�Ա����   setsid()
								field.set(obj, bigValue.intValue());
							}else{
								field.set(obj, bigValue.doubleValue());
							}
						}else if(value instanceof java.sql.Timestamp){
							// ��Ҫ��java.sql.Timestampת��Ϊjava.sql.Date
							java.sql.Timestamp time = (Timestamp) value;
							java.util.Date utilDate = new java.util.Date(time.getTime());
							java.sql.Date date = new java.sql.Date(utilDate.getTime());
							field.set(obj, date);
						}else{
							// ��ֵ��������Ķ���ĳ�Ա����
							field.set(obj, value);
						}
					}
				}
				// 4. ���ض�Ӧ�Ķ���
				return (T) obj;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, ps, rs);
		}
		return null;
	}
	/**
	 * ��ѯ��������
	 * @param sql ��Ҫִ�е�sql���
	 * @param cls ���ض����Ӧ�������   Student.class   newInstance()
	 * @param objs sql����ж�Ӧ��ռλ���Ĳ���
	 * @return
	 * 		��ѯ������
	 */
	public static <T> List<T> baseQuery(String sql,Class cls,Object ... objs){
		List<T> list = new ArrayList<>();
		// ��ȡ���ݿ������ͨ��
		 conn = DBUtil.getConnection();
		// ͨ�^JNDI�ķ�ʽ��ȥ����ͨ��
//		conn = JNDIDataConfig.getConnection();
		try {
			// ͨ��c3p0��ȡ���ݿ�����ͨ��
			//conn = DataSourceConfig.getDataSource().getConnection();
			ps = conn.prepareStatement(sql);
			// ��ռλ�����и�ֵ
			if(objs != null){
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			// ִ��sql���
			rs = ps.executeQuery();
			// Ԫ����   ��Ϊ�˻�ȡ���ݿ��ж����У��Լ�ÿһ�е�����
			ResultSetMetaData md = rs.getMetaData();
			int rowCount = md.getColumnCount();
			//System.out.println("�ܹ��ж����У�"+rowCount);
			while(rs.next()){
				// 2. ��ȡ��װ���ݵĶ�Ӧ�Ķ���
				Object obj = cls.newInstance(); //�൱��  Student student = new Student();
				//System.out.println(obj.getClass());
				// 1. �����м�¼�е�ÿһ���ֶμ���Ӧ��ֵȡ������
				for (int i = 0; i < rowCount; i++) {
					//����������ȡ�е����ƣ�Ϊ�˺���ͨ��������ȥ����JavaBean���ж�Ӧ��set����
					String name = md.getColumnLabel(i+1).toLowerCase();
					//��ȡÿһ�ж�Ӧ��ֵ
					Object value = rs.getObject(name);
					// �����ѯ���ֶε�ֵΪ�գ���ô��û�б�Ҫ���ո�ֵ�������������
					if(value == null){
						continue;
					}
					// System.out.println(name+":"+value+"���ͣ�"+value.getClass());
					// System.out.println(name+":"+value);
					// 3. ����ѯ���ֶε�ֵ���浽��Ӧ�Ķ���ĳ�Ա����(����)��
					// �ж���������Ƿ���ڱ����е��ֶζ�Ӧ�ĳ�Ա����
					if(hasField(cls, name)){
						// ���ݲ�ѯ���ֶε����ƻ�ȡ������ж�Ӧ�ĳ�Ա����
						Field field = cls.getDeclaredField(name);
						//System.out.println(field.getName());
						// �����˽�г�Ա������ֵ
						field.setAccessible(true);
						if(value instanceof BigDecimal){
							// value ����������Ҳ������С��
							BigDecimal bigValue = (BigDecimal) value;
							// �жϳ�Ա������ʲô���͵�
							if(field.getType().getName().equals("int")){
								// ��ֵ��������Ķ���ĳ�Ա����
								field.set(obj, bigValue.intValue());  //student.setSid()							}else{
								
							}else{
								field.set(obj, bigValue.doubleValue());
							}
						}else if(value instanceof java.sql.Timestamp){
							// ��Ҫ��java.sql.Timestampת��Ϊjava.sql.Date
							java.sql.Timestamp time = (Timestamp) value;
							java.util.Date utilDate = new java.util.Date(time.getTime());
							java.sql.Date date = new java.sql.Date(utilDate.getTime());
							field.set(obj, date);
						}else{
							// ��ֵ��������Ķ���ĳ�Ա����
							field.set(obj, value); //student.setSid()
						}
					}
				}
				// 4. �������ļ�¼���浽������
				list.add((T) obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, ps, rs);
		}
		return list;
	}
	
	/**
	 * �ж���������Ƿ����name����
	 * @param cls
	 * @param name
	 * @return
	 * 		true ����
	 * 		false ������
	 */
	public static boolean hasField(Class cls,String name){
		// ȡ��������е����е�����
		Field[] fls = cls.getDeclaredFields();
		for (Field field : fls) {
			//System.out.println(field.getName());
			if(field.getName().equals(name.trim())){
				return true;
			}
		}
		return false;
	}
	
	/*public static void fun1(int a,Object ... objs){
		System.out.println("������...");
		// ȡ���ɱ䳤�ȵĲ����б��е�����
		for (int i = 0; i < objs.length; i++) {
			System.out.println(objs[i]);
		}
	}
	*/
	
	private final String QUERY_BEGIN = " select t2.*,rownum from (select t1.*,rownum num from  ( ";
	private final String QUERY_END = " ) t1 where rownum <= ?) t2 where t2.num >= ? ";
	
	/**
	 * ��ҳ��ѯ
	 * @param countSql ��ѯ�ܵļ�¼����sql
	 * @param querySql �򵥲�ѯ���
	 * @param whereSql ��ѯ������
	 * @param otherSql ������sql
	 * @param pageSize ÿҳ��ʾ������
	 * @param currentPage ��ǰҳ
	 * @param cls  ��Ӧ�������
	 * @param list  ռλ����Ӧ������
	 * @return
	 *     ��ѯ�Ľ��
	 */
	public BasePage<T> queryByPage(StringBuilder countSql,StringBuilder querySql
			,StringBuilder whereSql,StringBuilder otherSql,int pageSize,int currentPage
			,Class cls ,List list){
		// 1.��ѯ�ܵļ�¼��
		// �������
		countSql.append(whereSql.toString());
		int count = this.baseQueryForCount(countSql.toString(),list.toArray());
		// 2.��ѯ��ҳ������
		// ��ѯ���������� select * from mc where 1=1 and mcname like '%abc%'
		querySql.append(whereSql.toString());
		querySql.insert(0, QUERY_BEGIN);
		querySql.append(QUERY_END);
		// ����ҳ����е�ռλ����ֵ
		list.add(pageSize*(currentPage+1));
		list.add(pageSize*currentPage+1);
		List<T> queryList = this.baseQuery(querySql.toString(), cls,list.toArray());
		BasePage<T> page = new BasePage<>();
		page.setCount(count);
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		page.setList(queryList);
		page.setTotal((count-1)/pageSize);
		return page;
	}
	
	
}
