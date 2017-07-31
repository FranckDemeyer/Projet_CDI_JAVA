package com.maville.back.soap.implementations;

import com.maville.back.dto.EventHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.EventHourService;
import com.maville.back.soap.interfaces.EventHourWebService;

public class EventHourWebServiceImpl implements EventHourWebService {
	
	private EventHourService service = ServiceFactory.getInstance().getEventHourService();

	@Override
	public EventHourDTO findEventHourById(int id) {
		return service.getEventHourById(id);
	}

	@Override
	public void addEventHour(EventHourDTO eventHour) {
		service.addEventHour(eventHour);
	}

	@Override
	public void deleteEventHour(EventHourDTO eventHour) {
		service.deleteEventHour(eventHour);
	}

	@Override
	public EventHourDTO updateEventHour(EventHourDTO eventHour) {
		return service.updateEventHour(eventHour);
	}

}
