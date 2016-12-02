package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.nutrition.dao.FoodDao;
import com.wet.api.nutrition.model.Food;

@Repository
public class FoodDaoJpa extends AbstractDaoJpa<Food> implements FoodDao
{
	public FoodDaoJpa() 
	{
		super(Food.class);
	}
}