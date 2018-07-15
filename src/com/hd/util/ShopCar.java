package com.hd.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hd.model.Mc;

/**
 * 购物车:
 *    特点一个会话只有一个购物车对象
 *    
 *    能装商品
 *    购物车需要具备的功能：
 *        1.购买商品，添加商品
 *        2.修改购物车中商品
 *        3.删除购物车中的商品
 *        4.清空购物车中的商品
 * @author dpb
 *
 */
public class ShopCar {

	// 用户购物的商品
	private List<Mc> list;
	//购物车的总价
	private double total;
	// 购物车中购买商品的总件数
	private int count;
	// 总类数
	private int countType;
	
	/****************保证一个会话只有一个购物车**************/
	/**
	 * 私有化无参构造方法，不允许外界直接实例化
	 */
	private ShopCar(){
		list = new ArrayList<>();
	}
	/**
	 * 给外界提供一个获取购物车实例的方法
	 * @param request
	 * @return
	 */
	public static ShopCar getShopCar(HttpServletRequest request){
		// 1.获取到HttpSession实例
		HttpSession session = request.getSession();
		// 2.从session作用域中获取购物车
		Object obj = session.getAttribute("SHOPCAR");
		if(obj != null){
			// 表示session作用域中已经存在了购物车，直接返回
			return (ShopCar) obj;
		}
		// 表示session作用域中不存在购物车，需要实例化
		ShopCar car = new ShopCar();
		// 将生成的购物车放入session作用域中
		session.setAttribute("SHOPCAR", car);
		return car;
	}
	
	/**********************对外的公共方法************************/
	/**
	 * 往购物车中添加商品
	 *    如果第一次添加那么直接将商品放入同时购物数量为一
	 *    如果不是第一次那么直接修改购物车中的改商品的数量+1
	 * @param mc
	 */
	public void add(Mc mc){
		// 表示不存在
		boolean flag = false;
		for (Mc m : list) {
			if(m.getMcid() == mc.getMcid()){
				// 表示购物车中已经存在了
				m.setShopNum(m.getShopNum()+1);
				flag = true;
				break;
			}
		}
		if(flag == false){
			// 表示商品部存在，
			mc.setShopNum(1);
			list.add(mc);
		}
		// 更新统计类的变量
		init();
	}
	/**
	 * 初始化统计相关的变量
	 */
	public void init(){
		total = 0 ;
		count = 0;
		for (Mc mc : list) {
			// 1.total 总价
			// 2.count 总数
			total += mc.getPrice()*mc.getShopNum();
			count += mc.getShopNum();
		}
		// 3.countType总类
		countType=list.size();
	}
	
	/**
	 * 修改商品的数量
	 * @param mcid
	 * @param num
	 */
	public void update(int mcid,int num){
		for (Mc mc : list) {
			if(mc.getMcid() == mcid){
				// 修改购买的数量
				mc.setShopNum(num);
				break;
			}
		}
		// 更新统计相关的数据
		init();
	}
	
	/**
	 * 从购物车中删除商品
	 * @param mcid
	 */
	public void delete(int mcid){
		for (Mc mc : list) {
			if(mc.getMcid() == mcid){
				// 表示当前循环的这个商品就是我们需要删除的
				list.remove(mc);
				break;
			}
		}
		// 更新统计相关的数据
		init();
	}
	
	/**
	 * 清空购物车
	 */
	public void clear(){
		list.clear();
		// 统计相关数据也要清掉
		init();
	}
	
	/********************对应的Get和Set方法**********************/
	public List<Mc> getList() {
		return list;
	}

	public void setList(List<Mc> list) {
		this.list = list;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCountType() {
		return countType;
	}

	public void setCountType(int countType) {
		this.countType = countType;
	}

	
}
