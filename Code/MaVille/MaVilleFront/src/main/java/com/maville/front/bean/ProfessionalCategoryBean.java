package com.maville.front.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.factories.ServiceFactory;

@ManagedBean(name="professionalCategory")
@SessionScoped
public class ProfessionalCategoryBean {

	/* Variables */
	
	private ProfessionalCategoryDTO category = new ProfessionalCategoryDTO();
	private static Map<Integer, ProfessionalCategoryDTO> categories = new HashMap<>();
	
	/* Getters and Setters */
	
	public ProfessionalCategoryDTO getCategory() {
		return category;
	}
	
	public void setCategory(ProfessionalCategoryDTO category) {
		this.category = category;
	}
	
	public static Map<Integer, ProfessionalCategoryDTO> getCategories() {
		return categories;
	}
	
	public static void setCategories(Map<Integer, ProfessionalCategoryDTO> categories) {
		ProfessionalCategoryBean.categories = categories;
	}

	/* Methods */
	
	private static void addCategory(ProfessionalCategoryDTO category) {
		categories.put(category.getProfessionalCategoryId(), category);
	}
	
	private static void deleteCategory(ProfessionalCategoryDTO category) {
		categories.remove(category.getProfessionalCategoryId());
	}
	
	private static void updateCategory(ProfessionalCategoryDTO category) {
		categories.put(category.getProfessionalCategoryId(), category);
	}
	
	public String add() {
		ServiceFactory.getInstance().getProfessionalCategoryService().addProfessionalCategory(category);
		addCategory(category);
		return "pcategory-added";
	}
	
	public String delete() {
		ServiceFactory.getInstance().getProfessionalCategoryService().deleteProfessionalCategory(category);
		deleteCategory(category);
		return "pcategory-deleted";
	}
	
	public String update() {
		category = ServiceFactory.getInstance().getProfessionalCategoryService().updateProfessionalCategory(category);
		updateCategory(category);
		return "pcategory-updated";
	}
	
}
