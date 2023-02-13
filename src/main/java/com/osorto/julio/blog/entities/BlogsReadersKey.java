package com.osorto.julio.blog.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Embeddable
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class BlogsReadersKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_reader")
	int idReader;

	@Column(name = "id_blog")
	int idBlog;

}
