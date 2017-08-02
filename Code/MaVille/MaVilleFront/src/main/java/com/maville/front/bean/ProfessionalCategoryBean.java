package com.maville.front.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.ProfessionalCategoryService;

@ManagedBean(name="professionalCategory")
@SessionScoped
public class ProfessionalCategoryBean implements Serializable {

	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private ProfessionalCategoryDTO category = new ProfessionalCategoryDTO();
	private ProfessionalCategoryService service = ServiceFactory.getInstance().getProfessionalCategoryService();
	
	/* Getters and Setters */
	
	public ProfessionalCategoryDTO getCategory() {
		return category;
	}
	
	public void setCategory(ProfessionalCategoryDTO category) {
		this.category = category;
	}
	
	/* Methods */
	
	public ProfessionalCategoryDTO getProfessionalCategoryById(int id) {
		return service.getProfessionalCategoryById(id);
	}
	
	public List<ProfessionalCategoryDTO> getAllProfessionalCategories() {
		return service.getAllProfessionalCategories();
	}
	
	public ProfessionalCategoryDTO getProfessionalCategoryByName(String name) {
		return service.getProfessionalCategoryByName(name);
	}
	
	List<ProfessionalDTO> getProfessionalsByProfessionalCategory(ProfessionalCategoryDTO category) {
		return service.getProfessionalsByProfessionalCategory(category);
	}
	
	public String add() {
		service.addProfessionalCategory(category);
		return "pcategory-added";
	}
	
	public String delete() {
		service.deleteProfessionalCategory(category);
		return "pcategory-deleted";
	}
	
	public String edit(ProfessionalCategoryDTO category) {
		this.category = category;
		return "pcategory-edit";
	}
	
	public String update() {
		category = service.updateProfessionalCategory(category);
		return "pcategory-updated";
	}
	
}
