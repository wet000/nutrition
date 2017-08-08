package com.wet.api.nutrition.service.usda.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaFoodSource;
import com.wet.api.nutrition.model.usda.json.UsdaFood;
import com.wet.api.nutrition.service.usda.UsdaFoodSourceDaoService;
import com.wet.api.nutrition.service.usda.UsdaFoodSourceService;

@Service
public class UsdaFoodSourceServiceImpl implements UsdaFoodSourceService
{
    @Autowired
    private UsdaFoodSourceDaoService usdaFoodSourceDaoService;

    @Override
    public void saveUsdaFoodSource(UsdaFood usdaFood, Food food, Source source)
    {
        UsdaFoodSource usdaFoodSource = usdaFoodSourceDaoService.findByUsdaFoodIdAndFoodAndSource(usdaFood.getNutritionDbNumber(), food, source);
        if (usdaFoodSource == null)
        {
            System.out.println("Couldn't find usda food source: " + usdaFood.getNutritionDbNumber());
            usdaFoodSource = new UsdaFoodSource();
            usdaFoodSource.setUsdaFoodId(usdaFood.getNutritionDbNumber());
            usdaFoodSource.setFood(food);
            usdaFoodSource.setSource(source);
            usdaFoodSource.setCreateDate(new Date());
            usdaFoodSourceDaoService.save(usdaFoodSource);
        }
        else
        {
            System.out.println("Found usda food source: " + usdaFoodSource);
        }
    }
}
