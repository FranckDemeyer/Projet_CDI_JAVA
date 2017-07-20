package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;

import com.maville.back.entities.DirectoryHour;

public interface DirectoryHourWebService {
	@WebMethod
	void addDirectoryHour(DirectoryHour directoryHour) throws Exception;
	@WebMethod
	void deleteDirectoryHour(DirectoryHour directoryHour);
	@WebMethod
	DirectoryHour findDirectoryCategory(int directoryHourId);
	@WebMethod
	List<DirectoryHour> findAllDirectoryHour();
	@WebMethod
	DirectoryHour updateDirectoryHour(DirectoryHour directoryHour) throws Exception;
}
