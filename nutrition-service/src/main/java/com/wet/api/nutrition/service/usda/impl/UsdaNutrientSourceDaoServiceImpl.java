package com.wet.api.nutrition.service.usda.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.usda.UsdaNutrientSourceDao;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaNutrientSource;
import com.wet.api.nutrition.service.usda.UsdaNutrientSourceDaoService;

@Service
public class UsdaNutrientSourceDaoServiceImpl extends AbstractCommonDaoService<UsdaNutrientSource> implements UsdaNutrientSourceDaoService
{
    @Autowired
    private UsdaNutrientSourceDao usdaNutrientSourceDao;

    @Override
    protected Dao<UsdaNutrientSource> getDao()
    {
        return usdaNutrientSourceDao;
    }

    @Override
    public UsdaNutrientSource findByUsdaNutrientIdAndNutrientAndSource(int usdaNutrientId, Nutrient nutrient, Source source)
    {
        return usdaNutrientSourceDao.findByUsdaNutrientIdAndNutrientAndSource(usdaNutrientId, nutrient, source);
    }
}