package com.wet.api.nutrition.dao.usda.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.impl.AbstractNutritionDaoJpa;
import com.wet.api.nutrition.dao.usda.UsdaNutrientSourceDao;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaNutrientSource;

@Repository
public class UsdaNutrientSourceDaoJpa extends AbstractNutritionDaoJpa<UsdaNutrientSource> implements UsdaNutrientSourceDao
{
    public UsdaNutrientSourceDaoJpa()
    {
        super(UsdaNutrientSource.class);
    }

    @Override
    public UsdaNutrientSource findByUsdaNutrientIdAndNutrientAndSource(int usdaNutrientId, Nutrient nutrient, Source source)
    {
        String qlString = "select o from " + type.getName()
                + " o where o.usdaNutrientId = :usdaNutrientId and o.nutrient.id = :nutrientId and o.source.id = :sourceId";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("usdaNutrientId", usdaNutrientId);
        query.setParameter("nutrientId", nutrient.getId());
        query.setParameter("sourceId", source.getId());
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<UsdaNutrientSource> usdaNutrientSources = query.getResultList();
        return usdaNutrientSources.isEmpty() ? null : usdaNutrientSources.get(0);
    }
}