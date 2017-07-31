package com.maville.back.service.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maville.back.dao.interfaces.DirectoryDAO;
import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.entities.Directory;
import com.maville.back.service.interfaces.DirectoryService;

@Service("directoryService")
@Transactional
public class DirectoryServiceImpl implements DirectoryService {

	@Autowired
	DirectoryDAO directorydao;
	
	@Override
	public DirectoryDTO getDirectoryById(int id) {
		DirectoryDTO directory = new DirectoryDTO();
		BeanUtils.copyProperties(directorydao.find(id), directory);
		return directory;
	}

	@Override
	public List<DirectoryDTO> getAllDirectories() {
		List<DirectoryDTO> listDirectory = null;
		BeanUtils.copyProperties(directorydao.findAll(), listDirectory);
		return listDirectory;
	}

	@Override
	public List<DirectoryDTO> getDirectoriesByName(String name) {
		List<DirectoryDTO> listDirectory = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		BeanUtils.copyProperties(directorydao.findGroup(Directory.GET_DIRECTORY_BYNAME, parameters), listDirectory);
		return listDirectory;
	}

	@Override
	public void addDirectory(DirectoryDTO directory) {
		// verify mandatory fields
		String err = "";
		if(directory.getName() == null || directory.getName().isEmpty()){
			err += "Le nom est obligatoire. ";
		}
		if (directory.getLat() == null || directory.getLat().isEmpty()){
			err += "La latitude est obligatoire. ";
		}
		if(directory.getLng() == null || directory.getLng().isEmpty()){
			err += "La longitude est obligatoire. ";
		}
		if(directory.getCategory() == null){
			err += "La catégorie est obligatoire";
		}
		if (err != ""){
			throw new IllegalArgumentException(err);
		}
		// verify if name isn't already used
		if(directorydao.find(directory.getDirectoryId()) != null){
			throw new RuntimeException("une entrée d'annuaire avec le même identifiant existe déjà");
		}
		for(DirectoryDTO dir : getDirectoriesByName(directory.getName())) {
			if(dir.equals(directory)){
				throw new RuntimeException("Une entrée d'annuaire similaire existe déjà");
			}
		}
		// save
		Directory entity = new Directory();
		BeanUtils.copyProperties(directory, entity);
		try {
			directorydao.save(entity);
		} catch(Exception e) {
			throw new RuntimeException("Erreur lors de l'enregistrement de l'entrée d'annuaire");
		}
	}

	@Override
	public void delecteDirectory(DirectoryDTO directory) {
		if (directorydao.find(directory.getDirectoryId()) == null) {
			throw new RuntimeException("Cette entrée d'annuaire n'existe pas");
		}
		Directory entity = new Directory();
		BeanUtils.copyProperties(directory, entity);
		try {
			directorydao.save(entity);
		} catch (Exception  e) {
			throw new RuntimeException("Erreur lors de l'enregistrement de l'entrée d'annuaire");
		}
	}

	@Override
	public DirectoryDTO updateDirectory(DirectoryDTO directory) {
		if (directorydao.find(directory.getDirectoryId()) == null) {
			throw new RuntimeException("Cette entrée d'annuaire n'existe pas");
		}
		Directory entity = new Directory();
		BeanUtils.copyProperties(directory, entity);
		try {
			entity = directorydao.update(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la mise à jour de l'entrée de l'annuaire");
		}
		return null;
	}

	@Override
	public List<DirectoryDTO> getDirectoriesByCategory(DirectoryCategoryDTO category) {
		List<DirectoryDTO> listDirectory = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("category", category);
		BeanUtils.copyProperties(directorydao.findGroup(Directory.GET_DIRECTORY_BYCATEGORY, parameters), listDirectory); 
		return listDirectory;
	}

	@Override
	public List<DirectoryDTO> getDirectoriesByCoord(String lat, String lng, double rayon) {
		List<DirectoryDTO> listDirectory = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("lat", lat);
		parameters.put("lng", lng);
		parameters.put("rayon", rayon);
		BeanUtils.copyProperties(directorydao.findGroup(Directory.GET_DIRECTORY_BYCOORD, parameters), listDirectory);
		return listDirectory;
	}

	@Override
	public List<DirectoryHourDTO> getDirectoryHoursByDirectory(DirectoryDTO directory) {
		List<DirectoryHourDTO> directoryHours = null;
		Directory entity = new Directory();
		BeanUtils.copyProperties(directory, entity);
		BeanUtils.copyProperties(directorydao.getDirectoryHoursByDirectory(entity), directoryHours);
		return directoryHours;
	}

}
