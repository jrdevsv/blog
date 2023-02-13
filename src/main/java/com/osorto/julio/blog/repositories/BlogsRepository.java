package com.osorto.julio.blog.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osorto.julio.blog.entities.Blogs;


@Repository
public interface BlogsRepository  extends JpaRepository<Blogs, Serializable>{

}
