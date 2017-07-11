package com.maville.back.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DirectoryHour {
	
	/* Variable */
	
	@ManyToOne
	private Directory directory;
	private String day;
	private String hour;

	/* Getters and Setters */
	
	public Directory getDirectory() {
		return directory;
	}
	
	public void setDirectory(Directory directory) {
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
