package org.lanqiao.dao;

import org.apache.catalina.User;

public interface UpdateDao {
public void update(User user);
public User getUserByLoginId(String longinid);
}
