package com.wet.api.nutrition.service;

import com.wet.api.common.service.CommonDaoService;
import com.wet.api.nutrition.model.NutrientGroup;

public interface NutrientGroupDaoService extends CommonDaoService<NutrientGroup>
{
    public NutrientGroup findByName(String name);
}
