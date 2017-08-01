package com.maville.front.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.DirectoryService;

@ManagedBean(name="directory")
@SessionScoped
public class DirectoryBean {
	
	/* Variables */
	
	private DirectoryDTO directory = new DirectoryDTO();
	private DirectoryService service = ServiceFactory.getInstance().getDirectoryService();
	
	/* liste des pages Directory*/
	private static final String listDirPage = "directory";
	private static final String createDirPage = "create-directory";
	private static final String editDirPage = "edit-directory";
	
	/* Getters and Setters */
	
	public DirectoryDTO getDirectory() {
		return directory;
	}
	
	public void setDirectory(DirectoryDTO directory) {
		this.directory = directory;
	}
	
	/* Methods */
	
	public DirectoryDTO getDirectoryById(int id) {
		return service.getDirectoryById(id);
	}
	
	public List<DirectoryDTO> getAllDirectories() {
		return service.getAllDirectories();
	}
	
	public List<DirectoryDTO> getDirectoriesByName(String name) {
		return service.getDirectoriesByName(name);
	}
	
	public List<DirectoryDTO> getDirectoriesByCategory (DirectoryCategoryDTO category) {
		return service.getDirectoriesByCategory(category);
	}
	
	public List<DirectoryDTO> getDirectoriesByCoord(String lat, String lng, double rayon) {
		return service.getDirectoriesByCoord(lat, lng, rayon);
	}
	
	public List<DirectoryHourDTO> getHoursByDirectory(DirectoryDTO directory) {
		return service.getDirectoryHoursByDirectory(directory);
	}
	
	public String create(){
		return createDirPage;
	}
	public String add() {
		service.addDirectory(directory);
		return listDirPage;
	}
	
	public String delete(DirectoryDTO directory) {
		this.directory = directory;
		service.delecteDirectory(this.directory);
		return listDirPage;
	}
	
	public String edit(DirectoryDTO directory) {
		this.directory = directory;
		return editDirPage;
	}
	
	public String update() {
		directory = service.updateDirectory(directory);
		return listDirPage;
	}
	
}
