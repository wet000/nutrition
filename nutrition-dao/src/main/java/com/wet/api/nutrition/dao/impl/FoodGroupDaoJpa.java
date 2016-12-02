package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.nutrition.dao.FoodGroupDao;
import com.wet.api.nutrition.model.FoodGroup;

@Repository
public class FoodGroupDaoJpa extends AbstractDaoJpa<FoodGroup> implements FoodGroupDao
{
	public FoodGroupDaoJpa() 
	{
		super(FoodGroup.class);
	}
}