package com.bilgeadam.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bilgeadam.entities.Ogrenci;

public class OgrenciDao implements IOgrenci<Ogrenci>{

	public void save(Ogrenci entity) {
		Session session = null;
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Student data is added to DB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Student to DB");
		} finally {
			session.close();
		}
		
	}
	
	public Ogrenci findByName(String firstname) {
		Session session = dataBaseConnectionHibernate();
		Ogrenci ogrenci = null;
		String hql = "select a from Ogrenci as a where a.firstName =:fn ";
		Query query = session.createQuery(hql);
		query.setParameter("fn", firstname);
	
		try {
			ogrenci = (Ogrenci) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("yeni yazar oluşturulcak");
		}
		if (ogrenci != null) {
			return ogrenci;
		} else {
			System.out.println("Bylynamadı");
			return null;
		}
	}

	public void delete(long id) {
		Session session = null;
		try {
			Ogrenci deletedStudent = find(id);
			if (deletedStudent != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deletedStudent);
				session.getTransaction().commit();
				System.out.println("Student data is deltede to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Student to DB");
		} finally {
			session.close();
		}
		
	}

	public void update(long id, Ogrenci entity) {
		Session session = null;
		try {
			Ogrenci student = find(id);

			if (student != null) {
				
				student.setAd(entity.getAd());
				student.setSoyad(entity.getSoyad());
				student.setCinsiyet(entity.getCinsiyet());
				student.setTel1(entity.getTel1());
				student.setTel2(entity.getTel2());
				student.setAdres1(entity.getAdres1());
				student.setAdres2(entity.getAdres2());
				student.setCinsiyet(entity.getEmail());

				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(student);
				session.getTransaction().commit();
				System.out.println("Student data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Student to DB");
		} finally {
			session.close();
		}
	}

	public List<Ogrenci> listAll() {
		
		Session session = null;
		session = dataBaseConnectionHibernate();
		List<Ogrenci> students = session.createQuery("from Ogrenci", Ogrenci.class).list();
		List<Ogrenci> studentList = students;
		studentList.forEach(System.out::println);
		return studentList;
	}
	

	public Ogrenci find(long id) {
		Session session = dataBaseConnectionHibernate();
		Ogrenci student;
		try {
			student = session.find(Ogrenci.class, id);
			if (student != null) {
				System.out.println("Student Found--> " + student);
				return student;
			} else {
				System.out.println("Student not found");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while adding Student to DB");
		} finally {
			session.close();
		}
		return null;
	}
	public List<Ogrenci> getByName(String firstname) {
		Transaction transaction = null;
		List<Ogrenci> list = null;

		try(Session session = dataBaseConnectionHibernate()) {

			// start transaction
			transaction = session.beginTransaction();			
			//get  objects
			list = session.createQuery("Select ogrenci from Ogrenci as ogrenci where ogrenci.ad like '"+firstname+"%'", Ogrenci.class).list();    			
			// commit transaction
			transaction.commit();							
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}		
		return list;

	}

	public List<Ogrenci> getBySurname(String surname) {
		Transaction transaction = null;
		List<Ogrenci> list = null;

		try(Session session = dataBaseConnectionHibernate()) {

			// start transaction
			transaction = session.beginTransaction();			
			//get  objects
			list = session.createQuery("Select ogrenci from Ogrenci as ogrenci where ogrenci.soyad like '"+surname+"%'", Ogrenci.class).list();    			
			// commit transaction
			transaction.commit();							
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}		
		return list;
	}

	public List<Ogrenci> getByEmail(String email) {
		Transaction transaction = null;
		List<Ogrenci> list = null;

		try(Session session = dataBaseConnectionHibernate()) {

			// start transaction
			transaction = session.beginTransaction();			
			//get  objects
			list = session.createQuery("Select ogrenci from Ogrenci as ogrenci where ogrenci.email like '"+email+"%'", Ogrenci.class).list();    			
			// commit transaction
			transaction.commit();							
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}		
		return list;
	}


	

}
