package com.osorto.julio.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osorto.julio.blog.entities.Blogs;
import com.osorto.julio.blog.repositories.BlogsRepository;
import com.osorto.julio.blog.services.BlogsService;

@Service
public class BlogsServiceImpl implements BlogsService {

	@Autowired
	BlogsRepository repo;
	
	@Override
	public Blogs save(Blogs blog) {
		return repo.save(blog);
	}

	@Override
	public Blogs update(Blogs blog) {
		return repo.save(blog);
	}

	@Override
	public Blogs findById(int idBlog) {

		return repo.findById(idBlog).get();
	}

	@Override
	public void delete(int idBlog) {
			repo.deleteById(idBlog);
	}

	@Override
	public List<Blogs> findAll() {
		return repo.findAll();
	}

}
