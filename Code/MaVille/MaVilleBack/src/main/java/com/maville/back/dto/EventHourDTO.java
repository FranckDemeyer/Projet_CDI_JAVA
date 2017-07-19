package com.maville.back.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EventHourDTO implements Serializable {
	
	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private EventDTO event;
	private LocalDateTime hour;

	/* Getters and Setters */
	
	public EventDTO getEvent() {
		return event;
	}
	
	public void setEventId(EventDTO event) {
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
