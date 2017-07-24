package com.maville.back.soap.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.dto.EventDTO;
import com.maville.back.dto.EventHourDTO;

@WebService
public interface EventWebService {
	@WebMethod
	void addEvent(EventDTO event) throws Exception;
	@WebMethod
	void deleteEvent(EventDTO event);
	@WebMethod
	EventDTO findEvent(int eventId);
	@WebMethod
	List<EventDTO> findAllEvent();
	@WebMethod
	List<EventDTO> findEventByName(String name);
	@WebMethod
	List<EventDTO> findEventByDate(LocalDateTime date);
	@WebMethod
	List<EventDTO> findEventByDateRange(LocalDateTime start, LocalDateTime end);
	@WebMethod
	List<EventHourDTO> findEventHourByEvent(EventDTO event);
	@WebMethod
	EventDTO updateEvent(EventDTO event) throws Exception;
}
