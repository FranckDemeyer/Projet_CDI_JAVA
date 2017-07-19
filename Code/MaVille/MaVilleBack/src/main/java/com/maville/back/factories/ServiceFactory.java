package com.maville.back.factories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.maville.back.service.interfaces.AccountService;
import com.maville.back.service.interfaces.ProfessionalCategoryService;


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
		return context.getBean("account", AccountService.class);
	}
	
	public ProfessionalCategoryService getCategoryService() {
		return context.getBean("category", ProfessionalCategoryService.class);
	}
	// TODO implementer le reste des services
}
