package com.osorto.julio.blog.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osorto.julio.blog.entities.Readers;
import com.osorto.julio.blog.repositories.ReadersRepository;
import com.osorto.julio.blog.services.ReadersService;

@Service
public class ReadersServiceImpl implements ReadersService {

	@Autowired
	ReadersRepository repo;

	@Override
	public Readers save(Readers reader) {
		return repo.save(reader);
	}

	@Override
	public Readers update(Readers reader) {
		return repo.save(reader);
	}

	@Override
	public Readers findById(int idReader) {
		return repo.findById(idReader).get();
	}

	@Override
	public void delete(int idReader) {
		repo.deleteById(idReader);
	}

	@Override
	public List<Readers> findAll() {
		return repo.findAll();
	}

}
