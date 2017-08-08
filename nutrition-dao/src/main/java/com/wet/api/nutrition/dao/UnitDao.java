package com.wet.api.nutrition.dao;

import com.wet.api.common.dao.Dao;
import com.wet.api.nutrition.model.Unit;

public interface UnitDao extends Dao<Unit>
{
    public Unit findByNameAndAbbreviation(String abbreviation);
}