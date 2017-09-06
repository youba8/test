package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.User;

public interface UserService {
	public void insertUser(User user);
	//1、拿到登录是否成功; 2、用户信息(userid,uloginid,upassword,usex,ustateid,uroleid......)
	public User login(String loginid,String password);
	public User getUserByLoginId(String loginid);
	public List<User>userlist(); 
	public void remove(String userid);
}
