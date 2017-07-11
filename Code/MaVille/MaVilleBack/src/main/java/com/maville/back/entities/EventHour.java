package com.maville.back.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class EventHour {
	
	/* Variables */
	
	@ManyToOne
	private Event event;
	private LocalDateTime hour;

	/* Getters and Setters */
	
	public Event getEvent() {
		return event;
	}
	
	public void setEventId(Event event) {
		this.event = event;
	}
	
	public LocalDateTime getHour() {
		return hour;
	}
	
	public void setHour(LocalDateTime hour) {
		this.hour = hour;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "EventHour > hour : " + hour;
	}
}
