package com.wet.api.nutrition.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.NutrientMeasure;
import com.wet.api.nutrition.service.NutrientMeasureDaoService;
import com.wet.api.nutrition.service.NutrientMeasureService;

@Service
public class NutrientMeasureServiceImpl implements NutrientMeasureService
{
    @Autowired
    private NutrientMeasureDaoService nutrientMeasureDaoService;

    @Override
    public void save(Food food, Nutrient nutrient, BigDecimal amountPerGram)
    {
        NutrientMeasure nutrientMeasure = nutrientMeasureDaoService.findByFoodAndNutrient(food, nutrient);
        if (nutrientMeasure == null)
        {
            System.out.println("Couldn't find nutrient measure for food id: " + food.getId() + "and , nutrient id: " + nutrient.getId());
            nutrientMeasure = new NutrientMeasure();
            nutrientMeasure.setFood(food);
            nutrientMeasure.setNutrient(nutrient);
            nutrientMeasure.setAmountPerGram(amountPerGram);
            nutrientMeasure.setCreateDate(new Date());
            nutrientMeasureDaoService.save(nutrientMeasure);
        }
        else
        {
            System.out.println("Found nutrient measure: " + nutrientMeasure);
        }
        
    }

}