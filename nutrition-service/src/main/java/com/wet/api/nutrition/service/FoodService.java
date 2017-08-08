package com.wet.api.nutrition.service;

import com.wet.api.nutrition.model.Food;

public interface FoodService
{
    public Food create(String foodName, String foodGroupName);
}
