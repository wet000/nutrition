package com.wet.api.nutrition.service;

import com.wet.api.nutrition.model.Nutrient;

public interface NutrientService
{
    public Nutrient create(String nutrientName, String nutrientGroupName, String unitName);
}
