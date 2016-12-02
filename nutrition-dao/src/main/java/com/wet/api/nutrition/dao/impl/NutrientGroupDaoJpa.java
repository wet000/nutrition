package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.nutrition.dao.NutrientGroupDao;
import com.wet.api.nutrition.model.NutrientGroup;

@Repository
public class NutrientGroupDaoJpa extends AbstractDaoJpa<NutrientGroup> implements NutrientGroupDao
{
	public NutrientGroupDaoJpa()
	{
		super(NutrientGroup.class);
	}
}