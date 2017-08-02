package com.maville.front.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.DirectoryCategoryService;

@ManagedBean(name="directoryCategory")
@RequestScoped
public class DirectoryCategoryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	/* Variables */
	
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
		category.setDirectoryCategoryId(0);
		List<DirectoryDTO> listDirectories = new ArrayList<>();
		category.setDirectories(listDirectories);
		service.addDirectoryCategory(category);
		return "directory-category";
//		return "dcategory-added";
	}
	
	public String delete(DirectoryCategoryDTO category) {
		this.category = category;
		service.deleteDirectoryCategory(this.category);
		category = new DirectoryCategoryDTO();
		return "directory-category";
//		return "dcategory-deleted";
	}
	
	public String edit(DirectoryCategoryDTO category) {
		this.category = category;
		return "update-dircat";
	}
	
	public String update() {
		category  = service.updateDirectoryCategory(category);
		// set to new not to have the name of previous category in display
		category = new DirectoryCategoryDTO();
		return "directory-category";
//		return "dcategory-updated";
	}
	
}
