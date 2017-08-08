package com.wet.api.nutrition.dao;

import com.wet.api.common.dao.Dao;
import com.wet.api.nutrition.model.FoodGroup;

public interface FoodGroupDao extends Dao<FoodGroup>
{
    public FoodGroup findByName(String name);
}