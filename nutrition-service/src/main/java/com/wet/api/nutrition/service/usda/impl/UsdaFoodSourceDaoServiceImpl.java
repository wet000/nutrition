package com.wet.api.nutrition.service.usda.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.common.dao.Dao;
import com.wet.api.common.service.impl.AbstractCommonDaoService;
import com.wet.api.nutrition.dao.usda.UsdaFoodSourceDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaFoodSource;
import com.wet.api.nutrition.service.usda.UsdaFoodSourceDaoService;

@Service
public class UsdaFoodSourceDaoServiceImpl extends AbstractCommonDaoService<UsdaFoodSource> implements UsdaFoodSourceDaoService
{
    @Autowired
    private UsdaFoodSourceDao usdaFoodSourceDao;
    
    @Override
    protected Dao<UsdaFoodSource> getDao()
    {
        return usdaFoodSourceDao;
    }

    @Override
    public UsdaFoodSource findByUsdaFoodIdAndFoodAndSource(int usdaFoodId, Food food, Source source)
    {
        return usdaFoodSourceDao.findByUsdaFoodIdAndFoodAndSource(usdaFoodId, food, source);
    }
}