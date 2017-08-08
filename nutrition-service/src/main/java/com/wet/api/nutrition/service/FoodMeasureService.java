package com.wet.api.nutrition.service;

import java.math.BigDecimal;

import com.wet.api.nutrition.model.Food;

public interface FoodMeasureService
{
    public void save(Food food, String size, BigDecimal quantity, BigDecimal grams);
}
