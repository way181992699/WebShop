package com.hd.model;

/**
 * JavaBean ��Ʒ���
 * @author dpb
 *
 */
public class McType {
	// �����
	private int typeid;
	// �������
	private String typename;
	// �������
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
