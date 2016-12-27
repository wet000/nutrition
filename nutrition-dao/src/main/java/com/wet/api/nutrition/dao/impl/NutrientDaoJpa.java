package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.NutrientDao;
import com.wet.api.nutrition.model.Nutrient;

@Repository
public class NutrientDaoJpa extends AbstractNutritionJpa<Nutrient> implements NutrientDao
{
	public NutrientDaoJpa() 
	{
		super(Nutrient.class);
	}
}