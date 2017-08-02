package com.maville.front.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.DirectoryCategoryService;

@ManagedBean(name="directoryCategory")
@SessionScoped
public class DirectoryCategoryBean implements Serializable {

	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private DirectoryCategoryDTO category = new DirectoryCategoryDTO();
	private DirectoryCategoryService service = ServiceFactory.getInstance().getDirectoryCategoryService();

	/* Getters and Setters */
	
	public DirectoryCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(DirectoryCategoryDTO category) {
		this.category = category;
	}

	/* Methods */
	
	public DirectoryCategoryDTO getDirectoryCategoryById(int id) {
		return service.getDirectoryCategoryById(id);
	}
	
	public List<DirectoryCategoryDTO> getAllDirectoryCategory() {
		return service.getAllDirectoryCategory();
	}
	
	public DirectoryCategoryDTO getDirectoryCategoryByName(String name) {
		return service.getDirectoryCategoryByName(name);
	}
	
	public List<DirectoryDTO> getDirectoriesByCategory(int categoryId) {
		return service.getDirectoriesByCategory(categoryId);
	}
	
	public String add() {
		service.addDirectoryCategory(category);
		return "dcategory-added";
	}
	
	public String delete() {
		service.deleteDirectoryCategory(category);
		return "dcategory-deleted";
	}
	
	public String edit(DirectoryCategoryDTO category) {
		this.category = category;
		return "dcategory-edit";
	}
	
	public String update() {
		category  = service.updateDirectoryCategory(category);
		return "dcategory-updated";
	}
	
}
