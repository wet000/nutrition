package com.wet.api.nutrition.usda.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.nutrition.usda.dao.UsdaNutrientSourceDao;
import com.wet.api.nutrition.usda.model.UsdaNutrientSource;

@Repository
public class UsdaNutrientSourceDaoJpa extends AbstractDaoJpa<UsdaNutrientSource> implements UsdaNutrientSourceDao
{
	public UsdaNutrientSourceDaoJpa()
	{
		super(UsdaNutrientSource.class);
	}
}