package com.wet.api.nutrition.service;

import com.wet.api.common.service.CommonDaoService;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.NutrientMeasure;

public interface NutrientMeasureDaoService extends CommonDaoService<NutrientMeasure>
{
    public NutrientMeasure findByFoodAndNutrient(Food food, Nutrient nutrient);
}