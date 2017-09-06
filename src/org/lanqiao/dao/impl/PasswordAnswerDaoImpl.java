package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lanqiao.dao.PasswordAnswerDao;
import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.util.DBUtil;

public class PasswordAnswerDaoImpl implements PasswordAnswerDao{

	@Override
	public void insert(PasswordAnswer passwordAnswer) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1拿到连接
			conn = DBUtil.getConnection();
			//2创建PreparedStatement对象;
			String sql="insert into t_passwordanswer values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, passwordAnswer.getAnswerid());
			ps.setString(2, passwordAnswer.getAquestion());
			ps.setString(3, passwordAnswer.getAnswer());
			ps.setString(4, passwordAnswer.getEmail());
			ps.setString(5, passwordAnswer.getUserid());
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

	public void remove(String userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1拿到连接
			conn = DBUtil.getConnection();
			//2创建PreparedStatement对象;
			String sql="delete from t_passwordanswer where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
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


