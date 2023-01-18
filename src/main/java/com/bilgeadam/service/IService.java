package com.bilgeadam.service;

import java.util.List;

public interface IService  <T>{
	public void save(T entity);

	public void delete(long id);

	public void update(long id, T entity);

	public List<T> listAll();
}
