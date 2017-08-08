package com.wet.api.nutrition.dao.usda;

import com.wet.api.common.dao.Dao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaFoodSource;

public interface UsdaFoodSourceDao extends Dao<UsdaFoodSource>
{
    public UsdaFoodSource findByUsdaFoodIdAndFoodAndSource(int usdaFoodId, Food food, Source source);
}