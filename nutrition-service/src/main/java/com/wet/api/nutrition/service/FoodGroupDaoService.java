package com.wet.api.nutrition.service;

import com.wet.api.common.service.CommonDaoService;
import com.wet.api.nutrition.model.FoodGroup;

public interface FoodGroupDaoService extends CommonDaoService<FoodGroup>
{
    public FoodGroup findByName(String name);
}