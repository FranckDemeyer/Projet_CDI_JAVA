package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.soap.interfaces.DirectoryWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.DirectoryWebService")
public class DirectoryWebServiceImpl implements DirectoryWebService {
	
	@Override
	public void addDirectory(DirectoryDTO directory) throws Exception {
		ServiceFactory.getInstance().getDirectoryService().addDirectory(directory);
	}

	@Override
	public void deleteDirectory(DirectoryDTO directory) {
		ServiceFactory.getInstance().getDirectoryService().delecteDirectory(directory);
	}

	@Override
	public DirectoryDTO findDirectoryById(int directoryId) {
		return ServiceFactory.getInstance().getDirectoryService().getDirectoryById(directoryId);
	}

	@Override
	public List<DirectoryDTO> findAllDirectories() {
		return ServiceFactory.getInstance().getDirectoryService().getAllDirectories();
	}

	@Override
	public List<DirectoryDTO> findDirectoriesByName(String name) {
		return ServiceFactory.getInstance().getDirectoryService().getDirectoriesByName(name);
	}

	@Override
	public DirectoryDTO updateDirectory(DirectoryDTO directory) throws Exception {
		return ServiceFactory.getInstance().getDirectoryService().updateDirectory(directory);
	}

	@Override
	public List<DirectoryDTO> findDirectoriesByCategory(DirectoryCategoryDTO category) {
		return ServiceFactory.getInstance().getDirectoryService().getDirectoriesByCategory(category);
	}

	@Override
	public List<DirectoryDTO> findDirectoriesByCoord(String lat, String lng, double rayon) {
		return ServiceFactory.getInstance().getDirectoryService().getDirectoriesByCoord(lat, lng, rayon);
	}

	@Override
	public List<DirectoryHourDTO> findDirectoryHoursByDirectory(DirectoryDTO directory) {
		return ServiceFactory.getInstance().getDirectoryService().getDirectoryHoursByDirectory(directory);
	}

}
