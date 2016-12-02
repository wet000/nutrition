package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.nutrition.dao.NutritionFactDao;
import com.wet.api.nutrition.model.NutritionFact;

@Repository
public class NutritionFactDaoJpa extends AbstractDaoJpa<NutritionFact> implements NutritionFactDao
{
	public NutritionFactDaoJpa()
	{
		super(NutritionFact.class);
	}
}