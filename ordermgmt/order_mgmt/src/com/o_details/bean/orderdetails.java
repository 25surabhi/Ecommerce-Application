package com.o_details.bean;

import java.sql.Date;

public class orderdetails {

	int order_id;
	int user_id;
	String prod_id;
	float price;
	Date order_date;
	String address;
	String ostatus;
	//String desc;
	
	/*public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}*/
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int orderId) {
		order_id = orderId;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prodId) {
		prod_id = prodId;
	}
	
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date orderDate) {
		order_date = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}	
	
}
