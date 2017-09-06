package org.lanqiao.entity;

public class Order {
private String orderid;
private String userid;
public Order(String orderid, String userid) {
	super();
	this.orderid = orderid;
	this.userid = userid;
}
public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public Order() {
	// TODO Auto-generated constructor stub
}
}
