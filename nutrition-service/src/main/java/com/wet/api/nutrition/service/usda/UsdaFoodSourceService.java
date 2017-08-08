package com.wet.api.nutrition.service.usda;

import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.json.UsdaFood;

public interface UsdaFoodSourceService
{
    public void saveUsdaFoodSource(UsdaFood usdaFood, Food food, Source source);
}
