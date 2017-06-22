package com.maville.back.entities;
public class CategoryType {
	/* Variables */
	private int id;
	private String name;
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
	/* Methods */
	@Override
	public String toString() {
		return "CategoryType [id=" + id + ", name=" + name + "]";
	}
}
