package org.lanqiao.service.impl;

import org.lanqiao.entity.Order;
import org.lanqiao.service.OrderService;

public class OrderServiceImpl implements OrderService {
org.lanqiao.dao.OrderDao dao=new org.lanqiao.dao.impl.OrderDaoImpl();
	@Override
	public void remove(String userid) {
		// TODO Auto-generated method stub
       dao.remove(userid);
	}
	@Override
	public Order getid(String userid) {
		// TODO Auto-generated method stub
		return dao.getid(userid);
	}

}
