package com.maville.front.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.EventHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.EventHourService;

@ManagedBean(name="eventHour")
@SessionScoped
public class EventHourBean {

	/* Variables */
	
	private EventHourDTO hour = new EventHourDTO();
	private EventHourService service = ServiceFactory.getInstance().getEventHourService();
	
	/* Getters and Setters */
	
	public EventHourDTO getHour() {
		return hour;
	}
	
	public void setHour(EventHourDTO hour) {
		this.hour = hour;
	}
	
	/* Methods */
	
	public EventHourDTO getEventHourById(int id) {
		return service.getEventHourById(id);
	}
	
	public String add() {
		service.addEventHour(hour);
		return "ehour-added";
	}
	
	public String delete() {
		service.deleteEventHour(hour);
		return "ehour-deleted";
	}
	
	public String edit(EventHourDTO hour) {
		this.hour = hour;
		return "ehour-edit";
	}
	
	public String update() {
		hour = service.updateEventHour(hour);
		return "ehour-updated";
	}
	
}
