package com.maville.back.factories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MongoDbFactory {

	private static MongoDbFactory instance;
	private static EntityManagerFactory mongoEmf;
	
	private MongoDbFactory(){
		
	}
	
	public static MongoDbFactory getInstance(){
		if (instance == null){
			mongoEmf = Persistence.createEntityManagerFactory("mongo-ogm");
			instance = new MongoDbFactory();
		}
		
		return instance;
	}
	
	public EntityManagerFactory getMongoEmf(){
		return mongoEmf;
	}
}
