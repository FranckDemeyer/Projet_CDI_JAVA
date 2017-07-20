package com.maville.back.service.interfaces;

import com.maville.back.dto.EventHourDTO;

public interface EventHourService {

	public EventHourDTO getEventHourById(int id);
	
	public void addEventHour(EventHourDTO eventHour);
	
	public void deleteEventHour(EventHourDTO eventHour);
	
	public EventHourDTO updateEventHour(EventHourDTO eventHour);
}
