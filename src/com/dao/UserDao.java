package com.dao;

import java.util.List;

import com.models.User;

public interface UserDao {
	
	public Integer addUser(User author);
	public Integer updateUser(User author);
	public Integer deleteUser(User author);
	public User getUserById(Integer id);
	public List<User> getAllUser();
	public User getUserByEmailAndPassword(String email, String password);

}
