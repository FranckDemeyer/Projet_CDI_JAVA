package com.maville.back.entities;
public class Category {
	/* Variables */
	private int id;
	private String name;
	private Category subCategory;
	private CategoryType categorytype;
	/* Getters and Setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Category subCategory) {
		this.subCategory = subCategory;
	}
	public CategoryType getCategorytype() {
		return categorytype;
	}
	public void setCategorytype(CategoryType categorytype) {
		this.categorytype = categorytype;
	}
	/* Methods */
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", subCategory=" + subCategory + ", categorytype="
				+ categorytype + "]";
	}
}
