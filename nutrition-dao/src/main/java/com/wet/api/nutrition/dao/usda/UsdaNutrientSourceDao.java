package com.wet.api.nutrition.dao.usda;

import com.wet.api.common.dao.Dao;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaNutrientSource;

public interface UsdaNutrientSourceDao extends Dao<UsdaNutrientSource>
{
    public UsdaNutrientSource findByUsdaNutrientIdAndNutrientAndSource(int usdaNutrientId, Nutrient nutrient, Source source);
}