package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.nutrition.dao.NutrientDao;
import com.wet.api.nutrition.model.Nutrient;

@Repository
public class NutrientDaoJpa extends AbstractDaoJpa<Nutrient> implements NutrientDao
{
	public NutrientDaoJpa() 
	{
		super(Nutrient.class);
	}
}