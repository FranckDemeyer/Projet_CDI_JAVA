package com.maville.front.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.DirectoryDTO;
import com.maville.back.factories.ServiceFactory;

@ManagedBean(name="directory")
@SessionScoped
public class DirectoryBean {
	
	/* Variables */
	
	private DirectoryDTO directory = new DirectoryDTO();
	private static Map<Integer, DirectoryDTO> directories = new HashMap<>();
	
	/* Getters and Setters */
	
	public DirectoryDTO getDirectory() {
		return directory;
	}
	
	public void setDirectory(DirectoryDTO directory) {
		this.directory = directory;
	}
	
	public static Map<Integer, DirectoryDTO> getDirectories() {
		return directories;
	}
	
	public static void setDirectories(Map<Integer, DirectoryDTO> directories) {
		DirectoryBean.directories = directories;
	}
	
	/* Methods */
	
	private static void addDirectory(DirectoryDTO directory) {
		directories.put(directory.getDirectoryId(), directory);
	}
	
	private static void deleteDirectory(DirectoryDTO directory) {
		directories.remove(directory.getDirectoryId());
	}
	
	private static void updateDirectory(DirectoryDTO directory) {
		directories.put(directory.getDirectoryId(), directory);
	}
	
	public String add() {
		ServiceFactory.getInstance().getDirectoryService().addDirectory(directory);
		addDirectory(directory);
		return "directory-added";
	}
	
	public String delete() {
		ServiceFactory.getInstance().getDirectoryService().delecteDirectory(directory);
		deleteDirectory(directory);
		return "directory-deleted";
	}
	
	public String update() {
		directory = ServiceFactory.getInstance().getDirectoryService().updateDirectory(directory);
		updateDirectory(directory);
		return "directory-updated";
	}
	
}
