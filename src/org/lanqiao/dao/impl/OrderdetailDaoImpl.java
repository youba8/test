package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lanqiao.dao.OrderdetailDao;
import org.lanqiao.util.DBUtil;

public class OrderdetailDaoImpl implements OrderdetailDao {

	@Override
	public void remove(String orderid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1拿到连接
			conn = DBUtil.getConnection();
			//2创建PreparedStatement对象;
			String sql="delete from t_orderdetail where orderid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, orderid);
			//3执行操作;
			ps.executeUpdate();
		}catch(Exception e){}
		finally{
			//5关闭对象
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	}


