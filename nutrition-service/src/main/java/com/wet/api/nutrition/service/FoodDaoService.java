package com.wet.api.nutrition.service;

import com.wet.api.common.service.CommonDaoService;
import com.wet.api.nutrition.model.Food;

public interface FoodDaoService extends CommonDaoService<Food>
{
    public Food findByName(String name);
}
