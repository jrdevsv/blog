package com.osorto.julio.blog.services;

import java.util.List;

import com.osorto.julio.blog.entities.User;

public interface UserService {

	public List<User> findAll();

	public void save(User user);

	public User findByUsername(String username);

}
