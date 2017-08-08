package com.wet.api.nutrition.dao;

import java.math.BigDecimal;

import com.wet.api.common.dao.Dao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.FoodMeasure;

public interface FoodMeasureDao extends Dao<FoodMeasure>
{
    public FoodMeasure findByFoodAndSizeAndQuantity(Food food, String size, BigDecimal quantity);
}