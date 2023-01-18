package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.util.Util;

public interface IOgrenci<T> {

	public void save(T entity);

	public void delete(long id);

	public void update(long id, T entity);

	public List<T> listAll();
	
	default Session dataBaseConnectionHibernate() {

		return Util.getSessionFactory().openSession();
	}
}
