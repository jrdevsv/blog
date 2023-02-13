package com.osorto.julio.blog.services;

import java.util.List;

import com.osorto.julio.blog.entities.Readers;

public interface ReadersService {

	public Readers save(Readers reader);

	public Readers update(Readers reader);

	public Readers findById(int idReader);

	public void delete(int idReader);

	public List<Readers> findAll();
}
