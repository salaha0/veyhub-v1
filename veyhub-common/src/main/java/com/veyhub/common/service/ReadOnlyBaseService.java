package com.veyhub.common.service;

import java.util.Optional;

public interface ReadOnlyBaseService<TE, T> {

	public Iterable<TE> findAll();

	public Optional<TE> findById(T id);

	public Iterable<TE> findAllByIds(Iterable<T> ids);

	public boolean existsById(T id);
}
