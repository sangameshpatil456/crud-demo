package com.crud.demo.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.demo.dao.CrudDemoDao;
import com.crud.demo.entity.User;
import com.crud.demo.repository.UserRepository;

@Repository
public class CrudDemoDaoImpl implements CrudDemoDao {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUser() {
		return userRepository.findByIsActive(true);
	}

	@Override
	public User getUserById(long userID) {
		return userRepository.findByUserIdAndIsActive(userID, true);
	}

	@Override
	public User saveUser(User user) {
		user.setCreatedDateTime(new Date());
		user.setUpdatedDateTime(new Date());
		user = userRepository.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User deleteUserById(long userID) {
		User user = userRepository.findById(userID).get();
		user.setActive(false);
		return user;
	}

}