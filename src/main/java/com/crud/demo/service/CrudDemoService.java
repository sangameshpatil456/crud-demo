package com.crud.demo.service;

import java.util.List;

import com.crud.demo.entity.User;

public interface CrudDemoService {

	public List<User> getUser();

	public User getUserById(long userID);

	public User saveUser(User user);

	public User updateUser(User user);

	public User deleteUserById(long userID);

}
