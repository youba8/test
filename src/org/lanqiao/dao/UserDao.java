package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.User;

public interface UserDao {
	public void insert(User user);
	public User getUserByLoginId(String loginid);
    public List<User>userlist();
    public void remove(String  userid);
}
