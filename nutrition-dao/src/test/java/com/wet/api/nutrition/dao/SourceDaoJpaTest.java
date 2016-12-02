package com.wet.api.nutrition.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.wet.api.nutrition.dao.SourceDao;

public class SourceDaoJpaTest extends SourceDaoTest
{
	@Autowired
	private SourceDao sourceDao;

	@Override
	protected SourceDao getSourceDao() 
	{
		return sourceDao;
	}
}