package com.maville.front.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.factories.ServiceFactory;

@ManagedBean(name="directoryHour")
@SessionScoped
public class DirectoryHourBean {
	
	/* Variables */
	
	private DirectoryHourDTO hour = new DirectoryHourDTO();
	private static Map<Integer, DirectoryHourDTO> hours = new HashMap<>();

	/* Getters and Setters */
	
	public DirectoryHourDTO getHour() {
		return hour;
	}

	public void setHour(DirectoryHourDTO hour) {
		this.hour = hour;
	}

	public Map<Integer, DirectoryHourDTO> getHours() {
		return hours;
	}

	public void setHours(Map<Integer, DirectoryHourDTO> hours) {
		DirectoryHourBean.hours = hours;
	}

	/* Methods */
	
	private static void addHour(DirectoryHourDTO hour) {
		hours.put(hour.getId(), hour);
	}
	
	private static void deleteHour(DirectoryHourDTO hour) {
		hours.remove(hour.getId());
	}
	
	private static void updateHour(DirectoryHourDTO hour) {
		hours.put(hour.getId(), hour);
	}
	
	public String add() {
		ServiceFactory.getInstance().getDirectoryHourService().addDirectoryHour(hour);
		addHour(hour);
		return "hour-added";
	}
	
	public String delete() {
		ServiceFactory.getInstance().getDirectoryHourService().deleteDirectoryHour(hour);
		deleteHour(hour);
		return "hour-deleted";
	}
	
	public String update() {
		hour = ServiceFactory.getInstance().getDirectoryHourService().updateDirectoryHour(hour);
		updateHour(hour);
		return "hour-updated";
	}
	
}
