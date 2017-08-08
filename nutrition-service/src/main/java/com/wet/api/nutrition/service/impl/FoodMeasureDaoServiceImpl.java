package com.wet.api.nutrition.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.FoodMeasureDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.FoodMeasure;
import com.wet.api.nutrition.service.FoodMeasureDaoService;

@Service
public class FoodMeasureDaoServiceImpl extends AbstractCommonDaoService<FoodMeasure> implements FoodMeasureDaoService
{
    @Autowired
    private FoodMeasureDao foodMeasureDao;

    @Override
    protected Dao<FoodMeasure> getDao()
    {
        return foodMeasureDao;
    }

    @Override
    public FoodMeasure findByFoodAndSizeAndQuantity(Food food, String size, BigDecimal quantity)
    {
        return foodMeasureDao.findByFoodAndSizeAndQuantity(food, size, quantity);
    }
}