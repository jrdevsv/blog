package com.osorto.julio.blog.services;

import java.util.List;

import com.osorto.julio.blog.entities.Blogs;

public interface BlogsService {
	
	public Blogs save(Blogs blog);
	
	public Blogs update(Blogs blog);
	
	public Blogs findById(int idBlog);
	
	public void delete(int idBlog);
	
	public List<Blogs> findAll();

}
