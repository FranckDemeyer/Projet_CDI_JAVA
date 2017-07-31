package com.maville.back.service.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maville.back.dao.interfaces.DirectoryHourDAO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.entities.DirectoryHour;
import com.maville.back.service.interfaces.DirectoryHourService;

@Service("directoryHourService")
@Transactional
public class DirectoryHourServiceImpl implements DirectoryHourService {

	@Autowired
	DirectoryHourDAO directoryHourDao;
	
	@Override
	public DirectoryHourDTO getDirectoryHourById(int id) {
		DirectoryHourDTO directoryHour = new DirectoryHourDTO();
		BeanUtils.copyProperties(directoryHourDao.find(id), directoryHour); 
		return directoryHour;
	}

	@Override
	public List<DirectoryHourDTO> getAllDirectoryHours() {
		List<DirectoryHourDTO> listDirectoryHours = null;
		BeanUtils.copyProperties(directoryHourDao.findAll(), listDirectoryHours);
		return listDirectoryHours;
	}

	@Override
	public List<DirectoryHourDTO> getHoursByDirectory(DirectoryDTO directory) {
		List<DirectoryHourDTO> listDirectoryHours = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("directory", directory);
		BeanUtils.copyProperties(directoryHourDao.findGroup(DirectoryHour.GET_DIRECTORYHOURS_BYDIRECTORY, parameters), listDirectoryHours); 
		return listDirectoryHours;
	}

	@Override
	public void addDirectoryHour(DirectoryHourDTO directoryHour) {
		// verify mandatory fields
		String err = "";
		if (directoryHour.getDirectory() == null){
			err += "L'entrée d'annuaire de rattachement est obligatoire. ";
		}
		if(directoryHour.getDay() == null || directoryHour.getDay().isEmpty()){
			err += "La date est obligatoire. ";
		}
		if(directoryHour.getHour() == null || directoryHour.getHour().isEmpty()){
			err += "L'heure est obligatoire.";
		}
		if (err != ""){
			throw new IllegalArgumentException(err);
		}
		// save
		DirectoryHour entity = new DirectoryHour();
		BeanUtils.copyProperties(directoryHour, entity);
		try{
			directoryHourDao.save(entity);
		} catch(Exception e) {
			throw new RuntimeException("Erreur lors de l'enregistrement de l'heure");
		}
	}

	@Override
	public void deleteDirectoryHour(DirectoryHourDTO directoryHour) {
		if(directoryHourDao.find(directoryHour.getId()) == null){
			throw new RuntimeException("La tranche d'heure n'existe pas.");
		}
		DirectoryHour entity = new DirectoryHour();
		BeanUtils.copyProperties(directoryHour, entity);
		try {
			directoryHourDao.delete(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la suppression de l'horaire.");
		}
	}

	@Override
	public DirectoryHourDTO updateDirectoryHour(DirectoryHourDTO directoryHour) {
		// verify mandatory fields
		String err = "";
		if (directoryHour.getDirectory() == null){
			err += "L'entrée d'annuaire de rattachement est obligatoire. ";
		}
		if(directoryHour.getDay() == null || directoryHour.getDay().isEmpty()){
			err += "La date est obligatoire. ";
		}
		if(directoryHour.getHour() == null || directoryHour.getHour().isEmpty()){
			err += "L'heure est obligatoire.";
		}
		if (err != ""){
			throw new IllegalArgumentException(err);
		}
		// save
		if(directoryHourDao.find(directoryHour.getId()) == null){
			throw new RuntimeException("La tranche d'heure n'existe pas.");
		}
		DirectoryHour entity = new DirectoryHour();
		BeanUtils.copyProperties(directoryHour, entity);
		try {
			entity = directoryHourDao.update(entity);
		} catch(Exception e) {
			throw new RuntimeException("Erreur lors de la mise à jour de l'horaire.");
		}
		BeanUtils.copyProperties(entity, directoryHour);
		return directoryHour;
	}

}
