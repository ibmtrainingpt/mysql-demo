package com.example.mysqldemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysqldemo.entity.User;
import com.example.mysqldemo.repo.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public int save(User user) {
		User savedUser = userRepository.save(user);
		return savedUser.getId();
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(int userId) {
		return userRepository.findById(userId);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
}
