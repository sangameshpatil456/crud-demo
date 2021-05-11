package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.entity.User;
import com.crud.demo.service.CrudDemoService;

@RestController
@RequestMapping("/user/")
public class CrudDemoController {
	
	@Autowired
	private CrudDemoService crudDemoService;

	@GetMapping
	public List<User> getUser() {
		List<User> user = crudDemoService.getUser();
		return user;
	}

	@GetMapping("{userID}")
	public User getUserById(@PathVariable(name = "userID") long userID) {
		User user = crudDemoService.getUserById(userID);
		return user;
	}

	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return crudDemoService.saveUser(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return crudDemoService.updateUser(user);
	}

	@DeleteMapping("{userID}")
	public List<User> deleteUserById(@PathVariable(name = "userID") long userID) {
		User user = crudDemoService.deleteUserById(userID);
		return crudDemoService.getUser();
	}
	
}