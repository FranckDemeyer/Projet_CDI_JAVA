package com.maville.back.dto;

import java.io.Serializable;

public class DirectoryHourDTO implements Serializable {
	
	/* Variable */
	
	private static final long serialVersionUID = 1L;
	private DirectoryDTO directory;
	private String day;
	private String hour;

	/* Getters and Setters */
	
	public DirectoryDTO getDirectory() {
		return directory;
	}
	
	public void setDirectory(DirectoryDTO directory) {
		this.directory = directory;
	}
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "DirectoryHour > day : " + day + ", time : " + hour;
	}
}
