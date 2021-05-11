package com.crud.demo.dao;

import java.util.List;

import com.crud.demo.entity.User;

public interface CrudDemoDao {

	public List<User> getUser();

	public User getUserById(long userID);

	public User saveUser(User user);

	public User updateUser(User user);

	public User deleteUserById(long userID);

}
