package com.maville.back.soap.implementations;

import javax.jws.WebService;

import com.maville.back.dto.EventHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.soap.interfaces.EventHourWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.EventHourWebService")
public class EventHourWebServiceImpl implements EventHourWebService {
	
	@Override
	public EventHourDTO findEventHourById(int id) {
		return ServiceFactory.getInstance().getEventHourService().getEventHourById(id);
	}

	@Override
	public void addEventHour(EventHourDTO eventHour) {
		ServiceFactory.getInstance().getEventHourService().addEventHour(eventHour);
	}

	@Override
	public void deleteEventHour(EventHourDTO eventHour) {
		ServiceFactory.getInstance().getEventHourService().deleteEventHour(eventHour);
	}

	@Override
	public EventHourDTO updateEventHour(EventHourDTO eventHour) {
		return ServiceFactory.getInstance().getEventHourService().updateEventHour(eventHour);
	}

}
