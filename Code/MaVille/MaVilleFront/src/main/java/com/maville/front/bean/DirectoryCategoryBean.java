package com.maville.front.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.factories.ServiceFactory;

@ManagedBean(name="directoryCategory")
@SessionScoped
public class DirectoryCategoryBean {

	/* Variables */
	
	private DirectoryCategoryDTO category = new DirectoryCategoryDTO();
	private static Map<Integer, DirectoryCategoryDTO> categories = new HashMap<>();

	/* Getters and Setters */
	
	public DirectoryCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(DirectoryCategoryDTO category) {
		this.category = category;
	}

	public Map<Integer, DirectoryCategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(Map<Integer, DirectoryCategoryDTO> categories) {
		DirectoryCategoryBean.categories = categories;
	}

	/* Methods */
	
	private static void addCategory(DirectoryCategoryDTO category) {
		categories.put(category.getDirectoryCategoryId(), category);
	}
	
	private static void deleteCategory(DirectoryCategoryDTO category) {
		categories.remove(category.getDirectoryCategoryId());
	}
	
	private static void updateCategory(DirectoryCategoryDTO category) {
		categories.put(category.getDirectoryCategoryId(), category);
	}
	
	public String add() {
		ServiceFactory.getInstance().getDirectoryCategoryService().addDirectoryCategory(category);
		addCategory(category);
		return "dcategory-added";
	}
	
	public String delete() {
		ServiceFactory.getInstance().getDirectoryCategoryService().deleteDirectoryCategory(category);
		deleteCategory(category);
		return "dcategory-deleted";
	}
	
	public String update() {
		category  = ServiceFactory.getInstance().getDirectoryCategoryService().updateDirectoryCategory(category);
		updateCategory(category);
		return "dcategory-updated";
	}
	
}
