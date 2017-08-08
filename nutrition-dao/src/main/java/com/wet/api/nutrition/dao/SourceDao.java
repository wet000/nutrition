package com.wet.api.nutrition.dao;

import com.wet.api.common.dao.Dao;
import com.wet.api.nutrition.model.Source;

public interface SourceDao extends Dao<Source>
{
    public Source findBySource(String source);
}