package com.wet.api.nutrition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.NutrientMeasureDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.NutrientMeasure;
import com.wet.api.nutrition.service.NutrientMeasureDaoService;

@Service
public class NutrientMeasureDaoServiceImpl extends AbstractCommonDaoService<NutrientMeasure> implements NutrientMeasureDaoService
{
    @Autowired
    private NutrientMeasureDao nutrientMeasureDao;

    @Override
    protected Dao<NutrientMeasure> getDao()
    {
        return nutrientMeasureDao;
    }

    @Override
    public NutrientMeasure findByFoodAndNutrient(Food food, Nutrient nutrient)
    {
        return nutrientMeasureDao.findByFoodAndNutrient(food, nutrient);
    }
}