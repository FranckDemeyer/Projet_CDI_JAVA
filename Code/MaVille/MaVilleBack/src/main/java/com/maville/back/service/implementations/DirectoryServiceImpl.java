package com.maville.back.service.implementations;

import java.util.ArrayList;
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
import com.maville.back.entities.DirectoryCategory;
import com.maville.back.entities.DirectoryHour;
import com.maville.back.service.interfaces.DirectoryService;

@Service("directoryService")
@Transactional
public class DirectoryServiceImpl implements DirectoryService {

	@Autowired
	DirectoryDAO directorydao;
	
	@Override
	public DirectoryDTO getDirectoryById(int id) {
		DirectoryDTO directory = new DirectoryDTO();
		Directory entity = directorydao.find(id);
		BeanUtils.copyProperties(entity, directory);
		DirectoryCategoryDTO category = new DirectoryCategoryDTO();
		BeanUtils.copyProperties(entity.getCategory(), category);
		directory.setCategory(category);
		return directory;
	}

	@Override
	public List<DirectoryDTO> getAllDirectories() {
		List<DirectoryDTO> listDirectory = new ArrayList<>();
		for (Directory entity : directorydao.findAll()){
			DirectoryDTO directory = new DirectoryDTO();
			BeanUtils.copyProperties(entity, directory);
			DirectoryCategoryDTO category = new DirectoryCategoryDTO();
			BeanUtils.copyProperties(entity.getCategory(), category);
			directory.setCategory(category);
			listDirectory.add(directory);
		}
		return listDirectory;
	}

	@Override
	public List<DirectoryDTO> getDirectoriesByName(String name) {
		List<DirectoryDTO> listDirectory = new ArrayList<>();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		for (Directory entity : directorydao.findGroup(Directory.GET_DIRECTORY_BYNAME, parameters)){
			DirectoryDTO directory = new DirectoryDTO();
			BeanUtils.copyProperties(entity, directory);
			DirectoryCategoryDTO category = new DirectoryCategoryDTO();
			BeanUtils.copyProperties(entity.getCategory(), category);
			directory.setCategory(category);
			listDirectory.add(directory);
		}
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
		DirectoryCategory categoryEntity = new DirectoryCategory();
		BeanUtils.copyProperties(directory.getCategory(), categoryEntity);
		entity.setCategory(categoryEntity);
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
		DirectoryCategory categoryEntity = new DirectoryCategory();
		BeanUtils.copyProperties(directory.getCategory(), categoryEntity);
		entity.setCategory(categoryEntity);
		try {
			directorydao.delete(entity);
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
		DirectoryCategory categoryEntity = new DirectoryCategory();
		BeanUtils.copyProperties(directory.getCategory(), categoryEntity);
		entity.setCategory(categoryEntity);
		try {
			entity = directorydao.update(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la mise à jour de l'entrée de l'annuaire");
		}
		return null;
	}

	@Override
	public List<DirectoryDTO> getDirectoriesByCategory(DirectoryCategoryDTO category) {
		List<DirectoryDTO> listDirectory = new ArrayList<>();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("category", category);
		for (Directory entity : directorydao.findGroup(Directory.GET_DIRECTORY_BYCATEGORY, parameters)){
			DirectoryDTO newDirectory = new DirectoryDTO();
			BeanUtils.copyProperties(entity, newDirectory);
			DirectoryCategoryDTO dirCategory = new DirectoryCategoryDTO();
			BeanUtils.copyProperties(entity.getCategory(), dirCategory);
			newDirectory.setCategory(dirCategory);
			listDirectory.add(newDirectory);
		}
		return listDirectory;
	}

	@Override
	public List<DirectoryDTO> getDirectoriesByCoord(String lat, String lng, double rayon) {
		List<DirectoryDTO> listDirectory = new ArrayList<>();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("lat", lat);
		parameters.put("lng", lng);
		parameters.put("rayon", rayon);
		for(Directory entity : directorydao.findGroup(Directory.GET_DIRECTORY_BYCOORD, parameters)){
			DirectoryDTO directory = new DirectoryDTO();
			BeanUtils.copyProperties(entity, directory);
			DirectoryCategoryDTO category = new DirectoryCategoryDTO();
			BeanUtils.copyProperties(entity.getCategory(), category);
			directory.setCategory(category);
			listDirectory.add(directory);
		}
		return listDirectory;
	}

	@Override
	public List<DirectoryHourDTO> getDirectoryHoursByDirectory(DirectoryDTO directory) {
		List<DirectoryHourDTO> listDirectoryHours = new ArrayList<>();
		Directory entity = new Directory();
		BeanUtils.copyProperties(directory, entity);
		for(DirectoryHour hourEntity : directorydao.getDirectoryHoursByDirectory(entity)){
			DirectoryHourDTO directoryHour = new DirectoryHourDTO();
			BeanUtils.copyProperties(hourEntity, directoryHour);
			listDirectoryHours.add(directoryHour);
		}
		return listDirectoryHours;
	}

}
