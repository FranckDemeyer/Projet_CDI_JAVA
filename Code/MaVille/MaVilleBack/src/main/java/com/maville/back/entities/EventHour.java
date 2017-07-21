package com.maville.back.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EventHour {
	
	/* Variables */

	@Id
	@GeneratedValue
	private int eventHourId;
	
	@ManyToOne
	private Event event;
	
	private LocalDateTime hour;

	/* Constructors */
	
	public EventHour() {
	}

	public EventHour(Event event, LocalDateTime hour) {
		this.event = event;
		this.hour = hour;
	}

	/* Getters and Setters */
	
	public int getEventHourId() {
		return eventHourId;
	}

	public void setEventHourId(int eventHourId) {
		this.eventHourId = eventHourId;
	}

	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
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
