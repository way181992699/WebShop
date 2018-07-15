package com.hd.service;

import java.util.List;

import com.hd.model.McType;

/**
 * service  商品类别
 * @author dpb
 *
 */
public interface IMcTypeService {
	/**
	 * 添加商品信息
	 * @param type 保存的有需要添加的数据的McType对象
	 * @return
	 * 		-1 表示操作失败
	 *      其他数字表示影响的行数
	 */
	public int add(McType type);
	
	/**
	 * 根据id删除商品类别的数据
	 * @param id 需要删除的数据的id
	 * @return
	 * 	   -1 表示操作失败
	 *     其他数字表示影响的行数
	 */
	public int delete(int id);
	
	/**
	 * 根据id根据商品类别的数据
	 * @param type 保存的有需要更新的数据及条件
	 * @return
	 *    -1 表示操作失败
	 *    其他数字表示更新影响的行数
	 */
	public int update(McType type);
	
	/**
	 * 查询所有的商品类别信息
	 * @return
	 *    查询的数据
	 */
	public List<McType> queryAll();
	
	/**
	 * 根据id查询商品类别信息
	 * @param id 需要查询的条件
	 * @return
	 *    查询的数据
	 */
	public McType queryById(int id);
	
	/**
	 * 查询出所有的商品大类的数据
	 * @return
	 */
	public List<McType> queryFather();
	
	/**
	 * 根据父类id查询所有的对应的子类
	 * @param id
	 * @return
	 */
	public List<McType> queryByFatherId(int id);
}
