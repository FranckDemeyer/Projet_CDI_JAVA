package com.maville.back.factories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.maville.back.service.interfaces.AccountService;
import com.maville.back.service.interfaces.DirectoryCategoryService;
import com.maville.back.service.interfaces.DirectoryHourService;
import com.maville.back.service.interfaces.DirectoryService;
import com.maville.back.service.interfaces.EventCategoryService;
import com.maville.back.service.interfaces.EventHourService;
import com.maville.back.service.interfaces.EventService;
import com.maville.back.service.interfaces.ProfessionalCategoryService;
import com.maville.back.service.interfaces.ProfessionalService;


public class ServiceFactory {
	private ServiceFactory() {
	}

	private static ServiceFactory instance = null;
	private static ApplicationContext context = null;

	public static ServiceFactory getInstance() {
		if (instance == null) {
			context = new AnnotationConfigApplicationContext();
			instance = new ServiceFactory();
		}
		return instance;
	}

	public AccountService getAccountService() {
		return context.getBean("accountService", AccountService.class);
	}
	
	public DirectoryService getDirectoryService() {
		return context.getBean("directoryService", DirectoryService.class);
	}
	
	public DirectoryCategoryService getDirectoryCategoryService() {
		return context.getBean("directoryCategoryService", DirectoryCategoryService.class);
	}
	
	public DirectoryHourService getDirectoryHourService() {
		return context.getBean("directoryHourService", DirectoryHourService.class);
	}
	
	public EventService getEventService() {
		return context.getBean("eventService", EventService.class);
	}
	
	public EventCategoryService getEventCategoryService() {
		return context.getBean("eventCategoryService", EventCategoryService.class);
	}
	
	public EventHourService getEventHourService() {
		return context.getBean("eventHourService", EventHourService.class);
	}
	
	public ProfessionalService getProfessionalService() {
			return context.getBean("professionalService", ProfessionalService.class);
	}
	
	public ProfessionalCategoryService getProfessionalCategoryService() {
		return context.getBean("professionalCategoryService", ProfessionalCategoryService.class);
	}

}
