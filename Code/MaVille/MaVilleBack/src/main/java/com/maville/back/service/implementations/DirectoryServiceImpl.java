package com.maville.back.service.implementations;

import java.util.List;

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
	public List<DirectoryDTO> getAllDirectory() {
		List<DirectoryDTO> listDirectory = null;
		BeanUtils.copyProperties(directorydao.findAll(), listDirectory);
		return listDirectory;
	}

	@Override
	public List<DirectoryDTO> getDirectoryByName(String name) {
		List<DirectoryDTO> listDirectory = null;
		// TODO implement new method from DAO
		//BeanUtils.copyProperties(directorydao, listDirectory);
		return listDirectory;
	}

	@Override
	public void addDirectory(DirectoryDTO directory) {
		if(directorydao.find(directory.getDirectoryId()) != null){
			throw new RuntimeException("une entrée d'annuaire avec le même identifiant existe déjà");
		}
		for(DirectoryDTO dir : getDirectoryByName(directory.getName())) {
			if(dir.equals(directory)){
				throw new RuntimeException("Une entrée d'annuaire similaire existe déjà");
			}
		}

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
	public List<DirectoryDTO> getDirectoryByCategory(DirectoryCategoryDTO category) {
		List<DirectoryDTO> listDirectory = null;
		// TODO 
		return listDirectory;
	}

	@Override
	public List<DirectoryDTO> getDirectoryByCoord(String lat, String lng, double rayon) {
		List<DirectoryDTO> listDirectory = null;
		// TODO 
		return listDirectory;
	}

	@Override
	public List<DirectoryHourDTO> getDirectoryHours(DirectoryDTO directory) {
		List<DirectoryHourDTO> directoryHours = null;
		// TODO
		return directoryHours;
	}

}
