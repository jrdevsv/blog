package com.osorto.julio.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osorto.julio.blog.entities.BlogsReaders;
import com.osorto.julio.blog.repositories.BlogsReadersRepository;
import com.osorto.julio.blog.services.BlogsReadersService;

@Service
public class BlogsReadersServiceImpl implements BlogsReadersService {

	@Autowired
	BlogsReadersRepository repo;

	@Override
	public BlogsReaders save(BlogsReaders b) {
		return repo.save(b);
	}

	@Override
	public BlogsReaders update(BlogsReaders b) {
		return repo.save(b);
	}

	@Override
	public List<BlogsReaders> findAll() {
		return repo.findAll();
	}

}
