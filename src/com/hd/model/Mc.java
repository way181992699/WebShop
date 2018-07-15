package com.hd.model;

import java.sql.Date;

/**
 * JavaBean 商品信息
 * @author dpb
 *
 */
public class Mc {
	// 商品编号
	private int mcid; 
	// 商品名称
	private String mcname;
	// 商品描述
	private String mcdecx;
	// 商品价格
	private double price;
	// 商品图片
	private String pic;
	// 时候缺货
	private String flag;
	// 商品所属小类编号
	private int smalltypeid;
	// 创建时间用 java.sql.Date
	private Date createdate;
	// 商品数量
	private int quantity;
	// 专门为购物车添加的属性：用户购买的数量
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
