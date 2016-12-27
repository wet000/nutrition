package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.NutritionFactDao;
import com.wet.api.nutrition.model.NutritionFact;

@Repository
public class NutritionFactDaoJpa extends AbstractNutritionJpa<NutritionFact> implements NutritionFactDao
{
	public NutritionFactDaoJpa()
	{
		super(NutritionFact.class);
	}
}