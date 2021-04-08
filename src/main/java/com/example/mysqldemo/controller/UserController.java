package com.example.mysqldemo.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysqldemo.entity.User;
import com.example.mysqldemo.service.IUserService;

@RestController
public class UserController {
	Logger logger = Logger.getLogger(UserController.class.getName());
	@Autowired
	private IUserService userService;

	@PostMapping("user")
	int createUser(@RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping("user")
	List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("user/{id}")
	Optional<User> getUser(@PathVariable("id") int userId) {
		return userService.getUser(userId);
	}

	@PutMapping("user/{id}")
	void updateUser(@RequestBody User user, @PathVariable("id") int userId) {
		logger.log(Level.INFO, "" + userId);
		user.setId(userId);
		userService.updateUser(user);
	}

	@DeleteMapping("user/{id}")
	void deleteUser(@PathVariable("id") int userId) {
		logger.log(Level.INFO, "" + userId);
		userService.deleteUser(userId);
	}
}
