package com.maville.back.service.implementations;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maville.back.dao.interfaces.EventHourDAO;
import com.maville.back.dto.EventHourDTO;
import com.maville.back.entities.EventHour;
import com.maville.back.service.interfaces.EventHourService;

@Transactional
@Service("eventHourService")
public class EventHourServiceImpl implements EventHourService {
	
	@Autowired
	private EventHourDAO eventHourDAO;

	@Override
	public EventHourDTO getEventHourById(int id) {
		EventHourDTO eventHour = new EventHourDTO();
		BeanUtils.copyProperties(eventHourDAO.find(id), eventHour);
		return eventHour;
	}

	@Override
	public void addEventHour(EventHourDTO eventHour) {
		EventHour entity = new EventHour();
		BeanUtils.copyProperties(eventHour, entity);
		try {
			eventHourDAO.save(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la création");
		}
	}

	@Override
	public void deleteEventHour(EventHourDTO eventHour) {
		if(getEventHourById(eventHour.getEventHourId()) == null) {throw new IllegalArgumentException("l'heure liée à cet evénement n'existe pas");}
		EventHour entity = new EventHour();
		BeanUtils.copyProperties(eventHour, entity);
		try {
			eventHourDAO.delete(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la suppression");
		}
	}
	

	@Override
	public EventHourDTO updateEventHour(EventHourDTO eventHour) {
		EventHour entity = new EventHour();
		BeanUtils.copyProperties(eventHour, entity);
		try {
			entity = eventHourDAO.update(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la mise à jour");
		}
		BeanUtils.copyProperties(entity, eventHour);
		return eventHour;
	}

}
