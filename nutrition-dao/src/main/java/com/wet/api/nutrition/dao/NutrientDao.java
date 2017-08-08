package com.wet.api.nutrition.dao;

import com.wet.api.common.dao.Dao;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Unit;

public interface NutrientDao extends Dao<Nutrient>
{
    public Nutrient findByNameAndUnit(String name, Unit unit);
}