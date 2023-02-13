package com.osorto.julio.blog.services;

import java.util.List;

import com.osorto.julio.blog.entities.BlogsReaders;

public interface BlogsReadersService {
	
	public BlogsReaders save(BlogsReaders b);
	
	public BlogsReaders update(BlogsReaders b);
	
	public List<BlogsReaders> findAll();

}
