package com.bilgeadam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Ogrenci {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String ad;
	private String soyad;
	private String Cinsiyet;
	
	private String tel1, tel2;
	private String adres1, adres2;
	private String email;
	
	public Ogrenci () {
		
	}

	public Ogrenci(String ad, String soyad, String cinsiyet, String tel1, String adres1, String email) {
		super();

		this.ad = ad;
		this.soyad = soyad;
		Cinsiyet = cinsiyet;
		this.tel1 = tel1;
		this.adres1 = adres1;
		this.email = email;
	}

	public Ogrenci(String ad, String soyad) {
		super();
		this.ad = ad;
		this.soyad = soyad;
	}
	
	
	
	
}
