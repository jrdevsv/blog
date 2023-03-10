package com.osorto.julio.blog.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = true, unique = true)
	private String email;

	@Column(nullable = false, length = 64)
	private String password;

	@Column(name = "first_name", nullable = true)
	private String firstName;

	@Column(name = "last_name", nullable = true)
	private String lastName;

	@Transient
	private String passwordConfirm;
}
