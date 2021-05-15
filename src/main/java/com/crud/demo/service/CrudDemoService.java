package com.crud.demo.service;

import java.util.List;

import com.crud.demo.entity.User;

public interface CrudDemoService {

	List<User> getUser();

	User getUserById(long userID);

	User saveUser(User user);

	User updateUser(User user);

	void deleteUserById(long userID);

}
