package com.wet.api.nutrition.service;

import com.wet.api.common.service.CommonDaoService;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Unit;

public interface NutrientDaoService extends CommonDaoService<Nutrient>
{
    public Nutrient findByNameAndUnit(String name, Unit unit);
}