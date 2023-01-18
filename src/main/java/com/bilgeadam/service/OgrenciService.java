package com.bilgeadam.service;

import java.util.List;
import java.util.Optional;

import com.bilgeadam.dao.OgrenciDao;
import com.bilgeadam.entities.Ogrenci;

public class OgrenciService implements IService<Ogrenci>{
	private OgrenciDao ogrenciDao;
	
	public OgrenciService() {
		this.ogrenciDao= new OgrenciDao();
	}
	@Override
	public void save(Ogrenci entity) {
		ogrenciDao.save(entity);
		
	}

	@Override
	public void delete(long id) {
		ogrenciDao.delete(id);
		
	}

	@Override
	public void update(long id, Ogrenci entity) {
		
		ogrenciDao.update(id, entity);
	}

	@Override
	public List<Ogrenci> listAll() {
	
		return ogrenciDao.listAll();
	}
	
	public Ogrenci find(Long id) {
		return ogrenciDao.find(id);
	}
	
	public List<Ogrenci> getByName(String firstname) {
		return ogrenciDao.getByName(firstname);
	}

	public List<Ogrenci> getBySurname(String surname) {
		return ogrenciDao.getBySurname(surname);

	}

	public List<Ogrenci> getByEmail(String email) {
		return ogrenciDao.getByEmail(email);
	}

	
	

}
