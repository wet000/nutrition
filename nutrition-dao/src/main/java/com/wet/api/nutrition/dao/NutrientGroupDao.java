package com.wet.api.nutrition.dao;

import com.wet.api.common.dao.Dao;
import com.wet.api.nutrition.model.NutrientGroup;

public interface NutrientGroupDao extends Dao<NutrientGroup>
{
    public NutrientGroup findByName(String name);
}