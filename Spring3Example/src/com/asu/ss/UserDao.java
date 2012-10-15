package com.asu.ss;

public interface UserDao {
	public void saveUser(User user);
	public void updateUser(User user);
	public User getUser(String emailId);
}
