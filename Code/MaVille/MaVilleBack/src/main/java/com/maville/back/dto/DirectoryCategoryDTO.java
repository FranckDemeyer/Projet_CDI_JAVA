package com.maville.back.dto;

import java.io.Serializable;
import java.util.List;

public class DirectoryCategoryDTO implements Serializable {
	
	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private int directoryCategoryId;
	private String name;
	private List<DirectoryDTO> directories;
	
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
	
	public List<DirectoryDTO> getDirectories() {
		return directories;
	}
	
	public void setDirectories(List<DirectoryDTO> directories) {
		this.directories = directories;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "DirectoryCategory > directoryCategoryId : " + directoryCategoryId + ", name : " + name;
	}

}
