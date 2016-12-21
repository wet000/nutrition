package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.SourceDao;
import com.wet.api.nutrition.model.Source;

@Repository
public class SourceDaoJpa extends AbstractNutritionJpa<Source> implements SourceDao
{
	public SourceDaoJpa()
	{
		super(Source.class);
	}
}