package org.lanqiao.service.impl;

import org.lanqiao.service.OrderdetailService;

public class OrderdetailServiceImpl implements OrderdetailService {
org.lanqiao.dao.OrderdetailDao dao=new org.lanqiao.dao.impl.OrderdetailDaoImpl();
	@Override
	public void remove(String orderid) {
		// TODO Auto-generated method stub
     dao.remove(orderid);
	}

}
