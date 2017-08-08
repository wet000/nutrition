package com.wet.api.nutrition.service.usda.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaNutrientSource;
import com.wet.api.nutrition.model.usda.json.UsdaNutrient;
import com.wet.api.nutrition.service.usda.UsdaNutrientSourceDaoService;
import com.wet.api.nutrition.service.usda.UsdaNutrientSourceService;

@Service
public class UsdaNutrientSourceServiceImpl implements UsdaNutrientSourceService
{
    @Autowired
    private UsdaNutrientSourceDaoService usdaNutrientSourceDaoService;
    
    @Override
    public void save(UsdaNutrient usdaNutrient, Nutrient nutrient, Source source)
    {
        UsdaNutrientSource usdaNutrientSource = usdaNutrientSourceDaoService.findByUsdaNutrientIdAndNutrientAndSource(usdaNutrient.getUsdaNutrientId(), nutrient, source);
        if (usdaNutrientSource == null)
        {
            System.out.println("Couldn't find usda nutrient source: " + usdaNutrient.getUsdaNutrientId());
            usdaNutrientSource = new UsdaNutrientSource();
            usdaNutrientSource.setUsdaNutrientId(usdaNutrient.getUsdaNutrientId());
            usdaNutrientSource.setNutrient(nutrient);
            usdaNutrientSource.setSource(source);
            usdaNutrientSource.setCreateDate(new Date());
            usdaNutrientSourceDaoService.save(usdaNutrientSource);
        }
        else
        {
            System.out.println("Found usda nutrient source: " + usdaNutrientSource);
        }
    }
}