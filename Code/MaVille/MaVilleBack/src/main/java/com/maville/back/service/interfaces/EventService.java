package com.maville.back.service.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import com.maville.back.dto.EventDTO;
import com.maville.back.dto.EventHourDTO;

public interface EventService {

	public EventDTO getEventById(int id);
	
	public List<EventDTO> getAllEvents();
	
	public List<EventDTO> getEventByName(String name);
	
	public List<EventDTO> getEventByDate(LocalDateTime date );
	
	public List<EventDTO> getEventByDateRange(LocalDateTime start, LocalDateTime end);
	
	public void addEvent(EventDTO event);
	
	public void deleteEvent(EventDTO event);
	
	public EventDTO updateEvent(EventDTO event);
	
	public List<EventHourDTO> getEventHours(EventDTO event);
	
}
