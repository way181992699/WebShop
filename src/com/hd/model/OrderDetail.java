package com.hd.model;

/**
 * JavaBean ¶©µ¥ÏêÇé
 * @author dpb
 *
 */
public class OrderDetail {

	private int detailid;
	private String orderid;
	private int mcid;
	private int buynum;
	
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getMcid() {
		return mcid;
	}
	public void setMcid(int mcid) {
		this.mcid = mcid;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	
	
}
