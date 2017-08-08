package com.wet.api.nutrition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.NutrientDao;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Unit;
import com.wet.api.nutrition.service.NutrientDaoService;

@Service
public class NutrientDaoServiceImpl extends AbstractCommonDaoService<Nutrient> implements NutrientDaoService
{
    @Autowired
    private NutrientDao nutrientDao;
    
    @Override
    protected Dao<Nutrient> getDao()
    {
        return nutrientDao;
    }
    
    @Override
    public Nutrient findByNameAndUnit(String name, Unit unit)
    {
       return nutrientDao.findByNameAndUnit(name, unit);
    }
}
