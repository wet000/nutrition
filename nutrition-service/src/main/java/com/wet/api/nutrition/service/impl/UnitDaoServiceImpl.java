package com.wet.api.nutrition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.UnitDao;
import com.wet.api.nutrition.model.Unit;
import com.wet.api.nutrition.service.UnitDaoService;

@Service
public class UnitDaoServiceImpl extends AbstractCommonDaoService<Unit> implements UnitDaoService
{
    @Autowired
    private UnitDao unitDao;

    @Override
    protected Dao<Unit> getDao()
    {
        return unitDao;
    }
    
    @Override
    public Unit findByNameAndAbbreviation(String abbreviation)
    {
        return unitDao.findByNameAndAbbreviation(abbreviation);
    }
}