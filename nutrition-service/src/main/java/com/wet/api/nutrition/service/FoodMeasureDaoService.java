package com.wet.api.nutrition.service;

import java.math.BigDecimal;

import com.wet.api.common.service.CommonDaoService;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.FoodMeasure;

public interface FoodMeasureDaoService extends CommonDaoService<FoodMeasure>
{
    public FoodMeasure findByFoodAndSizeAndQuantity(Food food, String size, BigDecimal quantity);
}