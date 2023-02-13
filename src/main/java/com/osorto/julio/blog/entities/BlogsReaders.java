package com.osorto.julio.blog.entities;

import java.util.Set;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "blogs_readers")
public class BlogsReaders {


	@EmbeddedId
	BlogsReadersKey id;

	@ManyToOne
	@MapsId("idBlog")
	@JoinColumn(name = "id_blog")
	Blogs blogs;

	@ManyToOne
	@MapsId("idReader")
	@JoinColumn(name = "id_reader")
	Readers readers;

}
