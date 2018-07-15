package com.hd.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 本项目中公共方法
 * @author dpb
 *
 */
public class WebUtil {

	/**
	 * 判断字符串时候为空
	 * @param str 需要判断的字符串
	 * @return
	 *    true 空
	 *    false 非空
	 */
	public static boolean isEmpty(String str){
		if(str != null && !"".equals(str)){
			return false;
		}
		return true;
	}
	
	/**
	 * 根据request获取传递过来的当前的页数
	 * @param request
	 * @param defValue 默认值
	 * @return
	 *    
	 */
	public static int getCurrentPage(HttpServletRequest request,int defValue){
		String currentPageStr = request.getParameter("currentPage");
		int currentPage = defValue;
		if(!WebUtil.isEmpty(currentPageStr)){
			// 表示请求有传过来具体是哪一页
			currentPage = parserInt(currentPageStr);
		}
		return currentPage;
	}
	
	/**
	 * 根据request获取传递过来的每页显示的条数
	 * @param request
	 * @param defValue 默认的条数
	 * @return
	 */
	public static int getPageSize(HttpServletRequest request,int defValue){
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = defValue;
		if(!WebUtil.isEmpty(pageSizeStr)){
			// 表示有pageSize
			pageSize = parserInt(pageSizeStr);
		}
		return pageSize;
	}
	
	/**
	 * 将数字类型的字符串转化成int
	 * @param val 需要转化的字符串
	 * @return
	 *    转化的结果
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
	 * 将数字类型的字符串转化成int
	 * @param val 需要转化的字符串
	 * @return
	 *    转化的结果
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
