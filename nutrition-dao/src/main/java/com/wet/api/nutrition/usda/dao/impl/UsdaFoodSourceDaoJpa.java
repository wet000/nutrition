package com.wet.api.nutrition.usda.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.impl.AbstractNutritionJpa;
import com.wet.api.nutrition.model.usda.UsdaFoodSource;
import com.wet.api.nutrition.usda.dao.UsdaFoodSourceDao;

@Repository
public class UsdaFoodSourceDaoJpa extends AbstractNutritionJpa<UsdaFoodSource> implements UsdaFoodSourceDao
{
	public UsdaFoodSourceDaoJpa()
	{
		super(UsdaFoodSource.class);
	}
}