package com.maville.back.dao.generics;

import java.util.List;
import java.util.Map;

public interface AbstractDAO <T, PK> {
	void delete(T entity);
	T find(PK entityId);
	List<T> findAll();
	T findOne(String namedQuery, Map<String, Object> parameters);
	T update(T entity);
	void save(T entity);
}
