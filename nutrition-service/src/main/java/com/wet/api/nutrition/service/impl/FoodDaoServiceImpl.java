package com.wet.api.nutrition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.FoodDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.service.FoodDaoService;

@Service
public class FoodDaoServiceImpl extends AbstractCommonDaoService<Food> implements FoodDaoService
{
    @Autowired
    private FoodDao foodDao;

    @Override
    protected Dao<Food> getDao()
    {
        return foodDao;
    }
    
    @Override
    public Food findByName(String name)
    {
        return foodDao.findByName(name);
    }    
}