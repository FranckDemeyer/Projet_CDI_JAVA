package com.maville.back.soap.publisher;

import javax.xml.ws.Endpoint;

import com.maville.back.soap.implementations.AccountWebServiceImpl;
import com.maville.back.soap.implementations.EventWebServiceImpl;
import com.maville.back.soap.implementations.ProfessionalCategoryWebServiceImpl;
import com.maville.back.soap.implementations.ProfessionalWebServiceImpl;

public class Publisher {
	
	//	http://localhost:8085/mytown/professional?wsdl
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8085/mytown/account", new AccountWebServiceImpl());
//		Endpoint.publish("http://localhost:8085/mytown/directory", new DirectoryWebServiceImpl());
//		Endpoint.publish("http://localhost:8085/mytown/directorycategory", new DirectoryCategoryWebServiceImpl());
//		Endpoint.publish("http://localhost:8085/mytown/directoryhour", new DirectoryHourWebServiceImpl());
		Endpoint.publish("http://localhost:8085/mytown/event", new EventWebServiceImpl());
//		Endpoint.publish("http://localhost:8085/mytown/eventcategory", new EventCategoryWebServiceImpl());
//		Endpoint.publish("http://localhost:8085/mytown/eventhour", new EventHourWebServiceImpl());
		Endpoint.publish("http://localhost:8085/mytown/professional", new ProfessionalWebServiceImpl());
		Endpoint.publish("http://localhost:8085/mytown/professionalcategory", new ProfessionalCategoryWebServiceImpl());
		System.out.println("started at localhost on port 8085...");
	}
}
