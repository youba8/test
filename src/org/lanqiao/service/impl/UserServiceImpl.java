package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;

public class UserServiceImpl implements UserService {
	private org.lanqiao.dao.UserDao dao = new org.lanqiao.dao.impl.UserDaoImpl();
	@Override
	public void insertUser(User user) {
		dao.insert(user);
	}
	@Override
	public User login(String loginid, String password) {
		User currentUser = dao.getUserByLoginId(loginid);
		User user = null;
		if(currentUser==null){//没有此账号;
			return null;
		}
		if(currentUser!=null){ //验证密码
			if(currentUser.getUpassword().equals(password)){
				user = currentUser;
				return user;
			}
		}
		return null;
	}
	@Override
	public User getUserByLoginId(String loginid) {
		// TODO Auto-generated method stub
		return dao.getUserByLoginId(loginid);
	}
	@Override
	public List<User> userlist() {
		// TODO Auto-generated method stub
		return dao.userlist();
	}
	@Override
	public void remove(String userid) {
		// TODO Auto-generated method stub
		dao.remove(userid);
	}

}
