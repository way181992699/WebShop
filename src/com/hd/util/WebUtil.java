package com.hd.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ����Ŀ�й�������
 * @author dpb
 *
 */
public class WebUtil {

	/**
	 * �ж��ַ���ʱ��Ϊ��
	 * @param str ��Ҫ�жϵ��ַ���
	 * @return
	 *    true ��
	 *    false �ǿ�
	 */
	public static boolean isEmpty(String str){
		if(str != null && !"".equals(str)){
			return false;
		}
		return true;
	}
	
	/**
	 * ����request��ȡ���ݹ����ĵ�ǰ��ҳ��
	 * @param request
	 * @param defValue Ĭ��ֵ
	 * @return
	 *    
	 */
	public static int getCurrentPage(HttpServletRequest request,int defValue){
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = defValue;
		if(!WebUtil.isEmpty(currentPageStr)){
			// ��ʾ�����д�������������һҳ
			currentPage = parserInt(currentPageStr);
		}
		return currentPage;
	}
	
	/**
	 * ����request��ȡ���ݹ�����ÿҳ��ʾ������
	 * @param request
	 * @param defValue Ĭ�ϵ�����
	 * @return
	 */
	public static int getPageSize(HttpServletRequest request,int defValue){
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = defValue;
		if(!WebUtil.isEmpty(pageSizeStr)){
			// ��ʾ��pageSize
			pageSize = parserInt(pageSizeStr);
		}
		return pageSize;
	}
	
	/**
	 * ���������͵��ַ���ת����int
	 * @param val ��Ҫת�����ַ���
	 * @return
	 *    ת���Ľ��
	 */
	public static int parserInt(String val){
		int num = 0;
		try{
			num = Integer.parseInt(val.trim());
		}catch(Exception e){
			
		}
		
		return num;
	}
	
	/**
	 * ���������͵��ַ���ת����int
	 * @param val ��Ҫת�����ַ���
	 * @return
	 *    ת���Ľ��
	 */
	public static double parserDouble(String val){
		double num = 0;
		try{
			num = Double.parseDouble(val.trim());
		}catch(Exception e){
			
		}
		
		return num;
	}
}
