package com.maville.front.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.DirectoryHourService;

@ManagedBean(name="directoryHour")
@SessionScoped
public class DirectoryHourBean implements Serializable {
	
	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private DirectoryHourDTO hour = new DirectoryHourDTO();
	private DirectoryHourService service = ServiceFactory.getInstance().getDirectoryHourService();

	/* Getters and Setters */
	
	public DirectoryHourDTO getHour() {
		return hour;
	}

	public void setHour(DirectoryHourDTO hour) {
		this.hour = hour;
	}

	/* Methods */
	
	public DirectoryHourDTO getDirectoryHourById(int id) {
		return service.getDirectoryHourById(id);
	}
	
	public List<DirectoryHourDTO> getAllDirectoryHours() {
		return service.getAllDirectoryHours();
	}
	
	public List<DirectoryHourDTO> getHoursByDirectory(DirectoryDTO directory) {
		return service.getHoursByDirectory(directory);
	}
	
	public String add() {
		service.addDirectoryHour(hour);
		return "dhour-added";
	}
	
	public String delete() {
		service.deleteDirectoryHour(hour);
		return "dhour-deleted";
	}
	
	public String edit(DirectoryHourDTO hour) {
		this.hour = hour;
		return "dhour-edit";
	}
	
	public String update() {
		hour = service.updateDirectoryHour(hour);
		return "dhour-updated";
	}
	
}
