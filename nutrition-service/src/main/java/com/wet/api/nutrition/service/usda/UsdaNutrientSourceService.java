package com.wet.api.nutrition.service.usda;

import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.json.UsdaNutrient;

public interface UsdaNutrientSourceService
{
    public void save(UsdaNutrient usdaNutrient, Nutrient nutrient, Source source);
}