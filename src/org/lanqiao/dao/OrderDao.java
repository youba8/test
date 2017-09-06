package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Order;

public interface OrderDao {
	  public void remove(String  userid);
	  public Order getid(String userid);
	  public void insert(Order order);
}
