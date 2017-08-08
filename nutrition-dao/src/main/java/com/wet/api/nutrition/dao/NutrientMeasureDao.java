package com.wet.api.nutrition.dao;

import com.wet.api.common.dao.Dao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.NutrientMeasure;

public interface NutrientMeasureDao extends Dao<NutrientMeasure>
{
    public NutrientMeasure findByFoodAndNutrient(Food food, Nutrient nutrient);
}