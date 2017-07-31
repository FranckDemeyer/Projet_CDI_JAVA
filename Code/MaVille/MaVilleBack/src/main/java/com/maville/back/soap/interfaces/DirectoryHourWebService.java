package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;

import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;

public interface DirectoryHourWebService {
	@WebMethod
	void addDirectoryHour(DirectoryHourDTO directoryHour) throws Exception;
	@WebMethod
	void deleteDirectoryHour(DirectoryHourDTO directoryHour);
	@WebMethod
	DirectoryHourDTO findDirectoryCategoryById(int directoryHourId);
	@WebMethod
	List<DirectoryHourDTO> findAllDirectoryHours();
	@WebMethod
	List<DirectoryHourDTO> findDirectoryHoursByDirectory(DirectoryDTO directory);
	@WebMethod
	DirectoryHourDTO updateDirectoryHour(DirectoryHourDTO directoryHour) throws Exception;
}
