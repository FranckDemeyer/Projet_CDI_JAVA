package com.maville.back.soap.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.dto.EventHourDTO;

@WebService
public interface EventHourWebService {
	@WebMethod
	EventHourDTO findEventHourById(int id);
	@WebMethod
	void addEventHour(EventHourDTO eventHour);
	@WebMethod
	void deleteEventHour(EventHourDTO eventHour);
	@WebMethod
	EventHourDTO updateEventHour(EventHourDTO eventHour);
}
