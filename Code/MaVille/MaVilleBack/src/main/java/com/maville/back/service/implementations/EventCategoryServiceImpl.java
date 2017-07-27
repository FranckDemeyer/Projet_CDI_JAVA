package com.maville.back.service.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maville.back.dao.interfaces.EventCategoryDAO;
import com.maville.back.dto.EventCategoryDTO;
import com.maville.back.dto.EventDTO;
import com.maville.back.entities.EventCategory;
import com.maville.back.service.interfaces.EventCategoryService;

@Service("eventCategoryService")
@Transactional
public class EventCategoryServiceImpl implements EventCategoryService {

	@Autowired
	EventCategoryDAO eventCategoryDao;
	
	@Override
	public EventCategoryDTO getEventCategoryById(int id) {
		EventCategoryDTO eventCategory = new EventCategoryDTO();
		BeanUtils.copyProperties(eventCategoryDao.find(id), eventCategory);
		return eventCategory;
	}

	@Override
	public List<EventCategoryDTO> getAllEventCategories() {
		List<EventCategoryDTO> listEventCategories = null;
		BeanUtils.copyProperties(eventCategoryDao.findAll(), listEventCategories);
		return listEventCategories;
	}

	@Override
	public List<EventDTO> getEventbyCategory(EventCategoryDTO category) {
		List<EventDTO> listEvents = null;
		EventCategory entity = new EventCategory();
		BeanUtils.copyProperties(eventCategoryDao.getEventbyCategory(entity), listEvents);
		return listEvents;
	}

	@Override
	public List<EventCategoryDTO> getEventCategoryByName(String name) {
		List<EventCategoryDTO> listEventCategories = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		BeanUtils.copyProperties(eventCategoryDao.findGroup(EventCategory.GET_CATEGORY_BY_NAME, parameters), listEventCategories);
		return listEventCategories;
	}

	@Override
	public void addEventCategory(EventCategoryDTO eventCategory) {
		// verify mandatory settings
		if (eventCategory.getName() == null || eventCategory.getName().isEmpty()){
			throw new IllegalArgumentException("Le nom est obligatoire.");
		}
		// verify if name isn't already used
		if(getEventCategoryByName(eventCategory.getName()) != null) {
			throw new RuntimeException("Ce nom est déjà utilisé.");
		}
		//save
		EventCategory entity = new EventCategory();
		BeanUtils.copyProperties(eventCategory, entity);
		try {
			eventCategoryDao.save(entity);
		} catch(Exception e){
			throw new RuntimeException("Erreur lors de l'enregistrement de la catégorie.");
		}
	}

	@Override
	public void deleteEventCategory(EventCategoryDTO eventCategory) {
		if (eventCategoryDao.find(eventCategory.getEventCategoryId()) == null){
			throw new RuntimeException("Cette catégorie n'existe pas");
		}
		EventCategory entity = new EventCategory();
		BeanUtils.copyProperties(eventCategory, entity);
		try {
			eventCategoryDao.delete(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la suppression de la catégorie.");
		}
	}

	@Override
	public EventCategoryDTO updateEventCategory(EventCategoryDTO eventCategory) {
		if (eventCategoryDao.find(eventCategory.getEventCategoryId()) == null){
			throw new RuntimeException("Cette catégorie n'existe pas");
		}
		EventCategory entity = new EventCategory();
		BeanUtils.copyProperties(eventCategory, entity);
		try {
			eventCategoryDao.update(entity);
		} catch(Exception e) {
			throw new RuntimeException("Erreur lors de la mise à jour de la catégorie.");
		}
		return eventCategory;
	}

}
