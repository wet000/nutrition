package com.wet.api.nutrition.service.usda;

import com.wet.api.common.service.CommonDaoService;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaNutrientSource;

public interface UsdaNutrientSourceDaoService extends CommonDaoService<UsdaNutrientSource>
{
    public UsdaNutrientSource findByUsdaNutrientIdAndNutrientAndSource(int usdaNutrientId, Nutrient nutrient, Source source);
}
