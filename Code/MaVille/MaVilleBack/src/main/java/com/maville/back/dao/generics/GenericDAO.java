package com.maville.back.dao.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;

public class GenericDAO<T, PK> implements AbstractDAO<T, PK> {
	
	/* Variables */
	
	private Class<T> entityClass;
	private Logger log = Logger.getLogger(getClass());
	protected EntityManager em;
	
	/* Constructors */

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	/* Getters and Setters */
	
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/* Methods */
	
	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for(Entry<String, Object> entry: parameters.entrySet()) query.setParameter(entry.getKey(), entry.getValue());
	}
	
	@Override
	public void delete(T entity) {
		T toRemove = em.merge(entity);
		em.remove(toRemove);
	}
	@Override
	public T find(PK entityId) {
		return em.find(entityClass, entityId);
	}

	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findOne(String namedQuery, Map<String, Object> parameters) {
		T result = null;
		try {
			Query query = em.createNamedQuery(namedQuery);
			if(parameters != null && !parameters.isEmpty()) populateQueryParameters(query, parameters);
			result = (T) query.getSingleResult();
		} catch (Exception e) {
			log.debug("Erreur dans la methode findOneResult : " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findGroup(String namedQuery, Map<String, Object> parameters) {
		List<T> results = new ArrayList<>();
		try {
			Query query = em.createNamedQuery(namedQuery);
			if(parameters != null && !parameters.isEmpty()) populateQueryParameters(query, parameters);
			results = query.getResultList();
		} catch (Exception e) {
			log.debug("Erreur dans la methode findGroupResults :" + e.getMessage());
			e.printStackTrace();
		}
		return results;
	}
	
	@Override
	public T update(T entity) {
		return em.merge(entity);
	}

	@Override
	public void save(T entity) {
		em.persist(entity);
		em.flush();
	}

}
