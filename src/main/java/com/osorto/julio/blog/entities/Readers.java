package com.osorto.julio.blog.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "readers")
public class Readers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length=8)
	private int idReader;

	@Column(length=8)
	private String name;
/*
	@ManyToMany
	@JoinTable(name = "blogs_readers", joinColumns = @JoinColumn(name = "idReader"), inverseJoinColumns = @JoinColumn(name = "idBlog"))
	Set<Blogs> blogsReaders;*/
	
	@OneToMany(mappedBy = "readers")
	Set<BlogsReaders> blogsReaders;
}
