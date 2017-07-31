package com.maville.back.soap.implementations;

import java.util.List;

import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.DirectoryHourService;
import com.maville.back.soap.interfaces.DirectoryHourWebService;

public class DirectoryHourWebServiceImpl implements DirectoryHourWebService {
	
	private DirectoryHourService service = ServiceFactory.getInstance().getDirectoryHourService();

	@Override
	public void addDirectoryHour(DirectoryHourDTO directoryHour) throws Exception {
		service.addDirectoryHour(directoryHour);
	}

	@Override
	public void deleteDirectoryHour(DirectoryHourDTO directoryHour) {
		service.deleteDirectoryHour(directoryHour);
	}

	@Override
	public DirectoryHourDTO findDirectoryCategoryById(int directoryHourId) {
		return service.getDirectoryHourById(directoryHourId);
	}

	@Override
	public List<DirectoryHourDTO> findAllDirectoryHours() {
		return service.getAllDirectoryHours();
	}

	@Override
	public List<DirectoryHourDTO> findDirectoryHoursByDirectory(DirectoryDTO directory) {
		return service.getHoursByDirectory(directory);
	}

	@Override
	public DirectoryHourDTO updateDirectoryHour(DirectoryHourDTO directoryHour) throws Exception {
		return service.updateDirectoryHour(directoryHour);
	}

}
