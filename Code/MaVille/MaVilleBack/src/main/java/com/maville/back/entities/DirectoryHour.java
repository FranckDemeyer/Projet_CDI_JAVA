package com.maville.back.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="directoryHour.getDirectoryHoursByDirectory", query="SELECT dh FROM DirectoryHour dh WHERE dh.directory = :directory")
public class DirectoryHour {
	
	/* Constants */
	
	public static final String GET_DIRECTORYHOURS_BYDIRECTORY = "directoryHour.getDirectoryHoursByDirectory";
	
	/* Variable */
	
	@Id
	@GeneratedValue
	private int directoryHourId;
	
	@ManyToOne
	private Directory directory;
	
	private String day;
	private String hour;

	/* Getters and Setters */
	
	public int getDirectoryHourId() {
		return directoryHourId;
	}

	public void setDirectoryHourId(int directoryHourId) {
		this.directoryHourId = directoryHourId;
	}

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
