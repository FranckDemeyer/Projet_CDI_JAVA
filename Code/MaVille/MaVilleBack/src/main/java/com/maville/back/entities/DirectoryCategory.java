package com.maville.back.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DirectoryCategory {
	
	/* Variables */
	
	@Id
	@GeneratedValue
	private int directoryCategoryId;
	private String name;
	@OneToMany(mappedBy="category")
	private List<Directory> directories;
	
	/* Getters and Setters */
	
	public int getDirectoryCategoryId() {
		return directoryCategoryId;
	}
	
	public void setDirectoryCategoryId(int directoryCategoryId) {
		this.directoryCategoryId = directoryCategoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Directory> getDirectories() {
		return directories;
	}
	
	public void setDirectories(List<Directory> directories) {
		this.directories = directories;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "DirectoryCategory > directoryCategoryId : " + directoryCategoryId + ", name : " + name;
	}

}
