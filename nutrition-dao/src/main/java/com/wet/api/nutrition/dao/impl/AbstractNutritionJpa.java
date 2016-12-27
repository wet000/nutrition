package com.wet.api.nutrition.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.common.model.DomainEntity;

public class AbstractNutritionJpa<T extends DomainEntity> extends AbstractDaoJpa<T>
{
	@PersistenceContext(unitName="nutritionPersistenceUnit")
	protected EntityManager entityManager;
	
	public AbstractNutritionJpa(Class<T> type)
	{
		super(type);
	}

	@Override
	protected EntityManager getEntityManager()
	{
		return entityManager;
	}
}