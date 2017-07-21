package com.maville.back.service.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maville.back.dao.interfaces.ProfessionalDAO;
import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.entities.Professional;
import com.maville.back.service.interfaces.ProfessionalService;

@Transactional
@Service("professionalService")
public class ProfessionalServiceImpl implements ProfessionalService {
	
	@Autowired
	private ProfessionalDAO professionalDAO;

	@Override
	public ProfessionalDTO getProfessionalById(int id) {
		ProfessionalDTO professional = new ProfessionalDTO();
		BeanUtils.copyProperties(professionalDAO.find(id), professional);
		return professional;
	}

	@Override
	public List<ProfessionalDTO> getAllProfessional() {
		List<ProfessionalDTO> professionals = null;
		BeanUtils.copyProperties(professionalDAO.findAll(), professionals);
		return professionals;
	}

	@Override
	public List<ProfessionalDTO> getProfessionalByName(String name) {
		List<ProfessionalDTO> professionals = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		BeanUtils.copyProperties(professionalDAO.findGroup(Professional.FIND_BY_NAME, parameters), professionals);
		return professionals;
	}

	@Override
	public List<ProfessionalDTO> getProfessionalByCategory(ProfessionalCategoryDTO category) {
		List<ProfessionalDTO> professionals = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("category", category.getProfessionalCategoryId());
		BeanUtils.copyProperties(professionalDAO.findGroup(Professional.FIND_BY_CATEGORY, parameters), professionals);
		return professionals;
	}

	@Override
	public List<ProfessionalDTO> getProfessionalByCoord(String lat, String lng, double radius) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProfessional(ProfessionalDTO professional) {
		if(getProfessionalByName(professional.getName()) != null) {throw new IllegalArgumentException("Ce professionnel existe d�j�");}
		Professional entity = new Professional();
		BeanUtils.copyProperties(professional, entity);
		try {
			professionalDAO.save(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la cr�ation");
		}
	}

	@Override
	public void deleteProfessional(ProfessionalDTO professional) {
		if(getProfessionalById(professional.getProfessionalId()) == null) {throw new IllegalArgumentException("Ce professionnel n'existe pas");}
		Professional entity = new Professional();
		BeanUtils.copyProperties(professional, entity);
		try {
			professionalDAO.delete(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la suppression");
		}
	}

	@Override
	public ProfessionalDTO updateProfessional(ProfessionalDTO professional) {
		Professional entity = new Professional();
		BeanUtils.copyProperties(professional, entity);
		try {
			entity = professionalDAO.update(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la suppression");
		}
		BeanUtils.copyProperties(entity, professional);
		return professional;
	}

}
