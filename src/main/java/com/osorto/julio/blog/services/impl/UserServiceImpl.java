package com.osorto.julio.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.osorto.julio.blog.entities.User;
import com.osorto.julio.blog.repositories.UserRepository;
import com.osorto.julio.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		return  repo.findByUsername(username);
	}
	

}
