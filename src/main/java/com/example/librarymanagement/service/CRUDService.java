package com.example.librarymanagement.service;

import java.util.List;

/**
 * @author mangvientrieu
 */
public interface CRUDService<T> {
	T create(T input);

	List<T> read();

	T update(T newValue);

	boolean delete(Long id);
}
