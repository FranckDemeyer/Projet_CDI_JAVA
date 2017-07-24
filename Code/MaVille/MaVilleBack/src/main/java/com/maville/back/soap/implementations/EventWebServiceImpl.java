package com.maville.back.soap.implementations;

import java.time.LocalDateTime;
import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.EventDTO;
import com.maville.back.dto.EventHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.soap.interfaces.EventWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.EventWebService")
public class EventWebServiceImpl implements EventWebService {

	@Override
	public void addEvent(EventDTO event) throws Exception {
		ServiceFactory.getInstance().getEventService().addEvent(event);
	}

	@Override
	public void deleteEvent(EventDTO event) {
		ServiceFactory.getInstance().getEventService().deleteEvent(event);
	}

	@Override
	public EventDTO findEvent(int eventId) {
		return ServiceFactory.getInstance().getEventService().getEventById(eventId);
	}

	@Override
	public List<EventDTO> findAllEvent() {
		return ServiceFactory.getInstance().getEventService().getAllEvents();
	}

	@Override
	public List<EventDTO> findEventByName(String name) {
		return ServiceFactory.getInstance().getEventService().getEventByName(name);
	}

	@Override
	public List<EventDTO> findEventByDate(LocalDateTime date) {
		return ServiceFactory.getInstance().getEventService().getEventByDate(date);
	}

	@Override
	public List<EventDTO> findEventByDateRange(LocalDateTime start, LocalDateTime end) {
		return ServiceFactory.getInstance().getEventService().getEventByDateRange(start, end);
	}

	@Override
	public List<EventHourDTO> findEventHourByEvent(EventDTO event) {
		return ServiceFactory.getInstance().getEventService().getEventHours(event);
	}

	@Override
	public EventDTO updateEvent(EventDTO event) throws Exception {
		return ServiceFactory.getInstance().getEventService().updateEvent(event);
	}

}
