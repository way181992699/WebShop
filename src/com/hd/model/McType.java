package com.hd.model;

/**
 * JavaBean 商品类别
 * @author dpb
 *
 */
public class McType {
	// 类别编号
	private int typeid;
	// 类别名称
	private String typename;
	// 父类别编号
	private int fatherid;
	
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getFatherid() {
		return fatherid;
	}
	public void setFatherid(int fatherid) {
		this.fatherid = fatherid;
	}
	@Override
	public String toString() {
		return "McType [typeid=" + typeid + ", typename=" + typename + ", fatherid=" + fatherid + "]";
	}
	public McType(int typeid, String typename, int fatherid) {
		super();
		this.typeid = typeid;
		this.typename = typename;
		this.fatherid = fatherid;
	}
	public McType() {
		super();
	}
	
	
	
	
}
