package com.wet.api.nutrition.usda.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.impl.AbstractNutritionJpa;
import com.wet.api.nutrition.model.usda.UsdaNutrientSource;
import com.wet.api.nutrition.usda.dao.UsdaNutrientSourceDao;

@Repository
public class UsdaNutrientSourceDaoJpa extends AbstractNutritionJpa<UsdaNutrientSource> implements UsdaNutrientSourceDao
{
	public UsdaNutrientSourceDaoJpa()
	{
		super(UsdaNutrientSource.class);
	}
}