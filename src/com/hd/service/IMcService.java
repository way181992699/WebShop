package com.hd.service;

import java.util.List;

import com.hd.model.Mc;
import com.hd.util.BasePage;

/**
 * Service 商品信息
 * @author dpb
 *
 */
public interface IMcService {
	/**
	 * 添加商品信息
	 * @param mc 需要添加的数据
	 * @return
	 * 	 -1 表示操作失败
	 *   其他表示影响的行数
	 */
	public int add(Mc mc);
	
	/**
	 * 更新商品信息
	 * @param mc 需要更新的数据和条件
	 * @return
	 * 	 -1 表示操作失败
	 *   其他表示影响的行数
	 */
	public int update(Mc mc);
	
	/**
	 * 根据id删除数据
	 * @param id 需要删除的条件
	 * @return
	 * 	 -1 表示操作失败
	 *   其他表示影响的行数
	 */
	public int delete(int id);
	
	/**
	 * 查询所有的商品信息
	 * @return
	 *   查询的结果
	 */
	public List<Mc> queryAll();
	
	/**
	 * 根据id查询商品信息
	 * @param id 查询的条件
	 * @return
	 *   查询的结果
	 */
	public Mc queryById(int id);
	
	/**
	 * 根据分页条件查询数据
	 * @param mc 查询的条件
	 * @param currentPage 查询的页数
	 * @param pageSize 每页显示的条数
	 * @return
	 *    查询的结果
	 */
	public BasePage<Mc> queryPage(Mc mc,int currentPage,int pageSize);

}
