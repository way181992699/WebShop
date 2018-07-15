package com.hd.model;

import java.sql.Date;

/**
 * JavaBean ��Ʒ��Ϣ
 * @author dpb
 *
 */
public class Mc {
	// ��Ʒ���
	private int mcid; 
	// ��Ʒ����
	private String mcname;
	// ��Ʒ����
	private String mcdecx;
	// ��Ʒ�۸�
	private double price;
	// ��ƷͼƬ
	private String pic;
	// ʱ��ȱ��
	private String flag;
	// ��Ʒ����С����
	private int smalltypeid;
	// ����ʱ���� java.sql.Date
	private Date createdate;
	// ��Ʒ����
	private int quantity;
	// ר��Ϊ���ﳵ��ӵ����ԣ��û����������
	private int shopNum;
	
	public int getShopNum() {
		return shopNum;
	}
	public void setShopNum(int shopNum) {
		this.shopNum = shopNum;
	}
	public int getMcid() {
		return mcid;
	}
	public void setMcid(int mcid) {
		this.mcid = mcid;
	}
	public String getMcname() {
		return mcname;
	}
	public void setMcname(String mcname) {
		this.mcname = mcname;
	}
	public String getMcdecx() {
		return mcdecx;
	}
	public void setMcdecx(String mcdecx) {
		this.mcdecx = mcdecx;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getSmalltypeid() {
		return smalltypeid;
	}
	public void setSmalltypeid(int smalltypeid) {
		this.smalltypeid = smalltypeid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Mc [mcid=" + mcid + ", mcname=" + mcname + ", mcdecx=" + mcdecx + ", price=" + price + ", pic=" + pic
				+ ", flag=" + flag + ", smalltypeid=" + smalltypeid + ", createdate=" + createdate + ", quantity="
				+ quantity + "]";
	}
	public Mc(int mcid, String mcname, String mcdecx, double price, String pic, String flag, int smalltypeid,
			Date createdate, int quantity) {
		super();
		this.mcid = mcid;
		this.mcname = mcname;
		this.mcdecx = mcdecx;
		this.price = price;
		this.pic = pic;
		this.flag = flag;
		this.smalltypeid = smalltypeid;
		this.createdate = createdate;
		this.quantity = quantity;
	}
	public Mc() {
		super();
	}
	
	
}
