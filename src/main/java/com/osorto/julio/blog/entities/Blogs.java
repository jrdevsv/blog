package com.osorto.julio.blog.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "blogs")
public class Blogs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 8)
	private int idBlog;

	@Column(length = 50)
	private String title;

	@Column(length = 4000)
	private String description;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "blogs_readers", joinColumns = @JoinColumn(name =
	 * "idBlog"), inverseJoinColumns = @JoinColumn(name = "idReader")) Set<Readers>
	 * blogsReaders;
	 */

	@OneToMany(mappedBy = "blogs")
	Set<BlogsReaders> blogsReaders;
}
