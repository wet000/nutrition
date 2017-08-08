package com.wet.api.nutrition.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.FoodMeasure;
import com.wet.api.nutrition.service.FoodMeasureDaoService;
import com.wet.api.nutrition.service.FoodMeasureService;

@Service
public class FoodMeasureServiceImpl implements FoodMeasureService
{
    @Autowired
    private FoodMeasureDaoService foodMeasureDaoService;
    
    @Override
    public void save(Food food, String size, BigDecimal quantity, BigDecimal grams)
    {
        FoodMeasure foodMeasure = foodMeasureDaoService.findByFoodAndSizeAndQuantity(food, size, quantity);
        if (foodMeasure == null)
        {
            System.out.println("Couldn't find food measure for food id: " + food.getId() + ", size: " + size + ", and quantity: " + quantity);
            foodMeasure = new FoodMeasure();
            foodMeasure.setFood(food);
            foodMeasure.setSize(size);
            foodMeasure.setQuantity(quantity);
            foodMeasure.setGrams(grams);
            foodMeasure.setCreateDate(new Date());
            foodMeasureDaoService.save(foodMeasure);
        }
        else
        {
            System.out.println("Found food measure: " + foodMeasure);
        }
    }
}