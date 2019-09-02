package com.veyhub.common.service;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.data.repository.CrudRepository;

public abstract class ReadOnlyBaseServiceImpl<TE, T> implements ReadOnlyBaseService<TE, T>{

	private CrudRepository<TE, T> repository;
	
	@PostConstruct
	public abstract void init();
	
    public void register(CrudRepository<TE, T> repository) {
    	this.repository = repository;
    }

	public Iterable<TE> findAll() {
		return repository.findAll();
	}

	public Optional<TE> findById(T id) {
		return repository.findById(id);
	}

	public Iterable<TE> findAllByIds(Iterable<T> ids) {
		return repository.findAllById(ids);
	}

	public boolean existsById(T id) {
		return repository.existsById(id);
	}
}
