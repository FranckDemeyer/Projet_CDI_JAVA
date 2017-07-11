package com.maville.back.factories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseFactory {

	private static DatabaseFactory instance = null;
	private static EntityManagerFactory emf = null;

	private DatabaseFactory() {
		
	}
	
	public static DatabaseFactory getInstance() {
		
		if(instance == null) {
			emf = Persistence.createEntityManagerFactory("jpaPU");
			instance = new DatabaseFactory();
		}
		
		return instance;
		
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}
	
}
