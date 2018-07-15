package com.hd.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hd.model.Mc;

/**
 * ���ﳵ:
 *    �ص�һ���Ựֻ��һ�����ﳵ����
 *    
 *    ��װ��Ʒ
 *    ���ﳵ��Ҫ�߱��Ĺ��ܣ�
 *        1.������Ʒ�������Ʒ
 *        2.�޸Ĺ��ﳵ����Ʒ
 *        3.ɾ�����ﳵ�е���Ʒ
 *        4.��չ��ﳵ�е���Ʒ
 * @author dpb
 *
 */
public class ShopCar {

	// �û��������Ʒ
	private List<Mc> list;
	//���ﳵ���ܼ�
	private double total;
	// ���ﳵ�й�����Ʒ���ܼ���
	private int count;
	// ������
	private int countType;
	
	/****************��֤һ���Ựֻ��һ�����ﳵ**************/
	/**
	 * ˽�л��޲ι��췽�������������ֱ��ʵ����
	 */
	private ShopCar(){
		list = new ArrayList<>();
	}
	/**
	 * ������ṩһ����ȡ���ﳵʵ���ķ���
	 * @param request
	 * @return
	 */
	public static ShopCar getShopCar(HttpServletRequest request){
		// 1.��ȡ��HttpSessionʵ��
		HttpSession session = request.getSession();
		// 2.��session�������л�ȡ���ﳵ
		Object obj = session.getAttribute("SHOPCAR");
		if(obj != null){
			// ��ʾsession���������Ѿ������˹��ﳵ��ֱ�ӷ���
			return (ShopCar) obj;
		}
		// ��ʾsession�������в����ڹ��ﳵ����Ҫʵ����
		ShopCar car = new ShopCar();
		// �����ɵĹ��ﳵ����session��������
		session.setAttribute("SHOPCAR", car);
		return car;
	}
	
	/**********************����Ĺ�������************************/
	/**
	 * �����ﳵ�������Ʒ
	 *    �����һ�������ôֱ�ӽ���Ʒ����ͬʱ��������Ϊһ
	 *    ������ǵ�һ����ôֱ���޸Ĺ��ﳵ�еĸ���Ʒ������+1
	 * @param mc
	 */
	public void add(Mc mc){
		// ��ʾ������
		boolean flag = false;
		for (Mc m : list) {
			if(m.getMcid() == mc.getMcid()){
				// ��ʾ���ﳵ���Ѿ�������
				m.setShopNum(m.getShopNum()+1);
				flag = true;
				break;
			}
		}
		if(flag == false){
			// ��ʾ��Ʒ�����ڣ�
			mc.setShopNum(1);
			list.add(mc);
		}
		// ����ͳ����ı���
		init();
	}
	/**
	 * ��ʼ��ͳ����صı���
	 */
	public void init(){
		total = 0 ;
		count = 0;
		for (Mc mc : list) {
			// 1.total �ܼ�
			// 2.count ����
			total += mc.getPrice()*mc.getShopNum();
			count += mc.getShopNum();
		}
		// 3.countType����
		countType=list.size();
	}
	
	/**
	 * �޸���Ʒ������
	 * @param mcid
	 * @param num
	 */
	public void update(int mcid,int num){
		for (Mc mc : list) {
			if(mc.getMcid() == mcid){
				// �޸Ĺ��������
				mc.setShopNum(num);
				break;
			}
		}
		// ����ͳ����ص�����
		init();
	}
	
	/**
	 * �ӹ��ﳵ��ɾ����Ʒ
	 * @param mcid
	 */
	public void delete(int mcid){
		for (Mc mc : list) {
			if(mc.getMcid() == mcid){
				// ��ʾ��ǰѭ���������Ʒ����������Ҫɾ����
				list.remove(mc);
				break;
			}
		}
		// ����ͳ����ص�����
		init();
	}
	
	/**
	 * ��չ��ﳵ
	 */
	public void clear(){
		list.clear();
		// ͳ���������ҲҪ���
		init();
	}
	
	/********************��Ӧ��Get��Set����**********************/
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
