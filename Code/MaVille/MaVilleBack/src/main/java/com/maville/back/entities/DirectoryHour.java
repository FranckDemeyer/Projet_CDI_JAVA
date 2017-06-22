package com.maville.back.entities;
public class DirectoryHour {
	/* Variable */
	private String dDay;
	private String dHour;
	/* Getters and Setters */
	public String getdDay() {
		return dDay;
	}
	public void setdDay(String dDay) {
		this.dDay = dDay;
	}
	public String getdHour() {
		return dHour;
	}
	public void setdHour(String dHour) {
		this.dHour = dHour;
	}
	/* Methods */
	@Override
	public String toString() {
		return "DirectoryHour [day=" + dDay + ", time=" + dHour + "]";
	}
}
