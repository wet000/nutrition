package com.wet.api.nutrition.service;

import com.wet.api.common.service.CommonDaoService;
import com.wet.api.nutrition.model.Unit;

public interface UnitDaoService extends CommonDaoService<Unit>
{
    public Unit findByNameAndAbbreviation(String abbreviation);
}
