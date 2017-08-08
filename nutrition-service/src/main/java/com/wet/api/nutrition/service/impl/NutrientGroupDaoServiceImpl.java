package com.wet.api.nutrition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.NutrientGroupDao;
import com.wet.api.nutrition.model.NutrientGroup;
import com.wet.api.nutrition.service.NutrientGroupDaoService;

@Service
public class NutrientGroupDaoServiceImpl extends AbstractCommonDaoService<NutrientGroup> implements NutrientGroupDaoService
{
    @Autowired
    private NutrientGroupDao nutrientGroupDao;
    
    @Override
    protected Dao<NutrientGroup> getDao()
    {
        return nutrientGroupDao;
    }

    @Override
    public NutrientGroup findByName(String name)
    {
        return nutrientGroupDao.findByName(name);
    }
}