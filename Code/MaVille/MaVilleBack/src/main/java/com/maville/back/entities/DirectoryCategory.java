package com.maville.back.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="directoryCategory.getDirectoryCategoryByName", query="SELECT dc FROM DirectoryCategory dc WHERE dc.name = :name"),
	@NamedQuery(name="directoryCategory.getDirectoriesByCategory", query="SELECT dc FROM DirectoryCategory dc WHERE dc.directories= :directories")
})
public class DirectoryCategory {
	
	/* Constants */
	
	public static final String GET_CATEGORY_BYNAME = "directoryCategory.getDirectoryCategoryByName";
	public static final String GET_DIRECTORIES_BYCATEGORY = "directoryCategory.getDirectoriesByCategory";
	
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
