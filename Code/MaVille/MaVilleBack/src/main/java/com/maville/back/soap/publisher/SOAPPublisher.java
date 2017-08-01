package com.maville.back.soap.publisher;

import javax.xml.ws.Endpoint;

import com.maville.back.soap.implementations.AccountWebServiceImpl;
import com.maville.back.soap.implementations.DirectoryCategoryWebServiceImpl;
import com.maville.back.soap.implementations.DirectoryHourWebServiceImpl;
import com.maville.back.soap.implementations.DirectoryWebServiceImpl;
import com.maville.back.soap.implementations.EventCategoryWebServiceImpl;
import com.maville.back.soap.implementations.EventHourWebServiceImpl;
import com.maville.back.soap.implementations.EventWebServiceImpl;
import com.maville.back.soap.implementations.ProfessionalCategoryWebServiceImpl;
import com.maville.back.soap.implementations.ProfessionalWebServiceImpl;

public class SOAPPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8085/maville/account", new AccountWebServiceImpl());
		Endpoint.publish("http://localhost:8085/maville/directorycategory", new DirectoryCategoryWebServiceImpl());
		Endpoint.publish("http://localhost:8085/maville/directoryhour", new DirectoryHourWebServiceImpl());
		Endpoint.publish("http://localhost:8085/maville/directory", new DirectoryWebServiceImpl());
		Endpoint.publish("http://localhost:8085/maville/eventcategory", new EventCategoryWebServiceImpl());
		Endpoint.publish("http://localhost:8085/maville/eventhour", new EventHourWebServiceImpl());
		Endpoint.publish("http://localhost:8085/maville/event", new EventWebServiceImpl());
		Endpoint.publish("http://localhost:8085/maville/professionalcategory", new ProfessionalCategoryWebServiceImpl());
		Endpoint.publish("http://localhost:8085/maville/professional", new ProfessionalWebServiceImpl());
		System.out.println("published.....");
	}

}
