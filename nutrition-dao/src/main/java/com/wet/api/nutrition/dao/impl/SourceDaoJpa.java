package com.wet.api.nutrition.dao.impl;

import org.springframework.stereotype.Repository;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.nutrition.dao.SourceDao;
import com.wet.api.nutrition.model.Source;

@Repository
public class SourceDaoJpa extends AbstractDaoJpa<Source> implements SourceDao
{
	public SourceDaoJpa()
	{
		super(Source.class);
	}
}