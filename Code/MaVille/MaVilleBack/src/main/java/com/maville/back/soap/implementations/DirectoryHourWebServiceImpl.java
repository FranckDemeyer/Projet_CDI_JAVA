package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.soap.interfaces.DirectoryHourWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.DirectoryHourWebService")
public class DirectoryHourWebServiceImpl implements DirectoryHourWebService {

	@Override
	public void addDirectoryHour(DirectoryHourDTO directoryHour) throws Exception {
		ServiceFactory.getInstance().getDirectoryHourService().addDirectoryHour(directoryHour);
	}

	@Override
	public void deleteDirectoryHour(DirectoryHourDTO directoryHour) {
		ServiceFactory.getInstance().getDirectoryHourService().deleteDirectoryHour(directoryHour);
	}

	@Override
	public DirectoryHourDTO findDirectoryCategoryById(int directoryHourId) {
		return ServiceFactory.getInstance().getDirectoryHourService().getDirectoryHourById(directoryHourId);
	}

	@Override
	public List<DirectoryHourDTO> findAllDirectoryHours() {
		return ServiceFactory.getInstance().getDirectoryHourService().getAllDirectoryHours();
	}

	@Override
	public List<DirectoryHourDTO> findDirectoryHoursByDirectory(DirectoryDTO directory) {
		return ServiceFactory.getInstance().getDirectoryHourService().getHoursByDirectory(directory);
	}

	@Override
	public DirectoryHourDTO updateDirectoryHour(DirectoryHourDTO directoryHour) throws Exception {
		return ServiceFactory.getInstance().getDirectoryHourService().updateDirectoryHour(directoryHour);
	}

}
