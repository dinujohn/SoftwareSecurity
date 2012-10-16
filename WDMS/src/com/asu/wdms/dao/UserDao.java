package com.asu.wdms.dao;

import com.asu.wdms.model.User;

public interface UserDao {
	public void saveUser(User user);
	public void updateUser(User user);
	public User getUser(String emailId);
}
