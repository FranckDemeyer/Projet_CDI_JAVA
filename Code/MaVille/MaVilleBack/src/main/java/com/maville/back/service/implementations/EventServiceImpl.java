package com.maville.back.service.implementations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maville.back.dao.interfaces.EventDAO;
import com.maville.back.dto.EventDTO;
import com.maville.back.dto.EventHourDTO;
import com.maville.back.entities.Event;
import com.maville.back.entities.EventHour;
import com.maville.back.service.interfaces.EventService;

@Transactional
@Service("eventService")
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventDAO eventDAO;

	@Override
	public EventDTO getEventById(int id) {
		EventDTO event = new EventDTO();
		BeanUtils.copyProperties(eventDAO.find(id), event);
		return event;
	}

	@Override
	public List<EventDTO> getAllEvents() {
		List<EventDTO> events = new ArrayList<>();
		for(Event event : eventDAO.findAll()) {
			EventDTO event2 = new EventDTO();
			BeanUtils.copyProperties(event, event2);
			events.add(event2);
		}
		return events;
	}

	@Override
	public List<EventDTO> getEventsByName(String name) {
		List<EventDTO> events = new ArrayList<>();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		for(Event event : eventDAO.findGroup(Event.FIND_BY_NAME, parameters)) {
			EventDTO event2 = new EventDTO();
			BeanUtils.copyProperties(event, event2);
			events.add(event2);
		}
		return events;
	}

	@Override
	public List<EventDTO> getEventsByDate(LocalDateTime date) {
		List<EventDTO> events = new ArrayList<>();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("datedeb", date);
		parameters.put("datefin", date.plusDays(1));
		for(Event event : eventDAO.findGroup(Event.FIND_BY_DATE, parameters)) {
			EventDTO event2 = new EventDTO();
			BeanUtils.copyProperties(event, event2);
			events.add(event2);
		}
		return events;
	}

	@Override
	public List<EventDTO> getEventsByDateRange(LocalDateTime start, LocalDateTime end) {
		List<EventDTO> events = new ArrayList<>();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("datedeb", start);
		parameters.put("datefin", end.plusDays(1));
		for(Event event : eventDAO.findGroup(Event.FIND_BY_DATE, parameters)) {
			EventDTO event2 = new EventDTO();
			BeanUtils.copyProperties(event, event2);
			events.add(event2);
		}
		return events;
	}

	@Override
	public void addEvent(EventDTO event) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", event.getName());
		parameters.put("hours", event.getHours());
		parameters.put("lat", event.getLat());
		parameters.put("lng", event.getLng());
		if(eventDAO.findGroup(Event.FIND_DUPLICATE, parameters).isEmpty()) {throw new IllegalArgumentException("Cet evénement existe déjà");}
		Event entity = new Event();
		BeanUtils.copyProperties(event, entity);
		try {
			eventDAO.save(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la création");
		}
	}

	@Override
	public void deleteEvent(EventDTO event) {
		if(getEventById(event.getEventId()) == null) {throw new IllegalArgumentException("Cet evénement n'existe pas");}
		Event entity = new Event();
		BeanUtils.copyProperties(event, entity);
		try {
			eventDAO.delete(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la suppression");
		}
	}

	@Override
	public EventDTO updateEvent(EventDTO event) {
		Event entity = new Event();
		BeanUtils.copyProperties(event, entity);
		try {
			entity = eventDAO.update(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la mise à jour");
		}
		BeanUtils.copyProperties(entity, event);
		return event;
	}

	@Override
	public List<EventHourDTO> getEventHours(EventDTO event) {
		List<EventHourDTO> eventHours = new ArrayList<>();
		for(EventHour eh : eventDAO.find(event.getEventId()).getHours()) {
			EventHourDTO eh2 = new EventHourDTO();
			BeanUtils.copyProperties(eh, eh2);
			eventHours.add(eh2);
	}
		return eventHours;
	}

}
