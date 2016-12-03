package com.wet.api.nutrition.usda.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.nutrition.model.usda.UsdaFoodSource;
import com.wet.api.nutrition.usda.dao.UsdaFoodSourceDao;

@Repository
public class UsdaFoodSourceDaoJpa extends AbstractDaoJpa<UsdaFoodSource> implements UsdaFoodSourceDao
{
	public UsdaFoodSourceDaoJpa()
	{
		super(UsdaFoodSource.class);
	}
}