package com.dao;

import java.util.List;

import com.models.User;

public interface UserDao {
	
	public Integer addUser(User author);
	public Integer updateUser(User author);
	public Integer deleteUser(User author);
	public User getUserById();
	public List<User> getAllUser();

}
