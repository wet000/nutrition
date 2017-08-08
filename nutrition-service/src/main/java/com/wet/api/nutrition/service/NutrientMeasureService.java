package com.wet.api.nutrition.service;

import java.math.BigDecimal;

import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Nutrient;

public interface NutrientMeasureService
{
    public void save(Food food, Nutrient nutrient, BigDecimal amountPerGram);
}