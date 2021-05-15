package com.crud.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.dao.CrudDemoDao;
import com.crud.demo.entity.User;
import com.crud.demo.service.CrudDemoService;

@Service
public class CrudDemoServiceImpl implements CrudDemoService{
	
	@Autowired
	private CrudDemoDao crudDemoDao;

	@Override
	public List<User> getUser() {
		return crudDemoDao.getUser();
	}

	@Override
	public User getUserById(long userID) {
		return crudDemoDao.getUserById(userID);
	}

	@Override
	public User saveUser(User user) {
		return crudDemoDao.saveUser(user);
	}

	@Override
	public User updateUser(User user) {
		return crudDemoDao.updateUser(user);
	}

	@Override
	public void deleteUserById(long userID) {
		crudDemoDao.deleteUserById(userID);
	}

}