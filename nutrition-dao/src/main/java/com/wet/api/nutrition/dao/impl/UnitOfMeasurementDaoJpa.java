package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.UnitOfMeasurementDao;
import com.wet.api.nutrition.model.UnitOfMeasurement;

@Repository
public class UnitOfMeasurementDaoJpa extends AbstractNutritionJpa<UnitOfMeasurement> implements UnitOfMeasurementDao
{
	public UnitOfMeasurementDaoJpa() 
	{
		super(UnitOfMeasurement.class);
	}
}