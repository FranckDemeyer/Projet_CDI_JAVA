package com.maville.back.soap.implementations;

import java.time.LocalDateTime;
import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.EventDTO;
import com.maville.back.dto.EventHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.EventService;
import com.maville.back.soap.interfaces.EventWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.EventWebService")
public class EventWebServiceImpl implements EventWebService {
	
	private EventService service = ServiceFactory.getInstance().getEventService();

	@Override
	public void addEvent(EventDTO event) throws Exception {
		service.addEvent(event);
	}

	@Override
	public void deleteEvent(EventDTO event) {
		service.deleteEvent(event);
	}

	@Override
	public EventDTO findEvent(int eventId) {
		return service.getEventById(eventId);
	}

	@Override
	public List<EventDTO> findAllEvent() {
		return service.getAllEvents();
	}

	@Override
	public List<EventDTO> findEventByName(String name) {
		return service.getEventsByName(name);
	}

	@Override
	public List<EventDTO> findEventByDate(LocalDateTime date) {
		return service.getEventsByDate(date);
	}

	@Override
	public List<EventDTO> findEventByDateRange(LocalDateTime start, LocalDateTime end) {
		return service.getEventsByDateRange(start, end);
	}

	@Override
	public List<EventHourDTO> findEventHourByEvent(EventDTO event) {
		return service.getEventHours(event);
	}

	@Override
	public EventDTO updateEvent(EventDTO event) throws Exception {
		return service.updateEvent(event);
	}

}
