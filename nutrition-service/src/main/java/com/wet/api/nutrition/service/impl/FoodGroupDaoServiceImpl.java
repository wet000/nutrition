package com.wet.api.nutrition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.FoodGroupDao;
import com.wet.api.nutrition.model.FoodGroup;
import com.wet.api.nutrition.service.FoodGroupDaoService;

@Service
public class FoodGroupDaoServiceImpl extends AbstractCommonDaoService<FoodGroup> implements FoodGroupDaoService
{
    @Autowired
    private FoodGroupDao foodGroupDao;
    
    @Override
    protected Dao<FoodGroup> getDao()
    {
        return foodGroupDao;
    }

    @Override
    public FoodGroup findByName(String name)
    {
        return foodGroupDao.findByName(name);
    }
}