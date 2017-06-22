package com.maville.back.entities;
import java.time.LocalDateTime;
public class EventHour {
	/* Variables */
	private Event event;
	private LocalDateTime eHour;
	/* Getters and Setters */
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public LocalDateTime geteHour() {
		return eHour;
	}
	public void seteHour(LocalDateTime eHour) {
		this.eHour = eHour;
	}
	/* Methods */
	@Override
	public String toString() {
		return "EventHour [event=" + event + ", eHour=" + eHour + "]";
	}
}
