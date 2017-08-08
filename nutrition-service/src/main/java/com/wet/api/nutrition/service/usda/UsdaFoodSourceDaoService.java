package com.wet.api.nutrition.service.usda;

import com.wet.api.common.service.CommonDaoService;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaFoodSource;

public interface UsdaFoodSourceDaoService extends CommonDaoService<UsdaFoodSource>
{
    public UsdaFoodSource findByUsdaFoodIdAndFoodAndSource(int usdaFoodId, Food food, Source source);
}
