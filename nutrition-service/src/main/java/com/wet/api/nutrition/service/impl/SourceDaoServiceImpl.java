package com.wet.api.nutrition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.SourceDao;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.service.SourceDaoService;

@Service
public class SourceDaoServiceImpl extends AbstractCommonDaoService<Source> implements SourceDaoService 
{
	@Autowired
	private SourceDao sourceDao;

	@Override
	protected Dao<Source> getDao() 
	{
		return sourceDao;
	}

    @Override
    public Source findBySource(String source)
    {
        return sourceDao.findBySource(source);
    }
}