package com.wet.api.nutrition.dao.usda.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.impl.AbstractNutritionDaoJpa;
import com.wet.api.nutrition.dao.usda.UsdaFoodSourceDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaFoodSource;

@Repository
public class UsdaFoodSourceDaoJpa extends AbstractNutritionDaoJpa<UsdaFoodSource> implements UsdaFoodSourceDao
{
    public UsdaFoodSourceDaoJpa()
    {
        super(UsdaFoodSource.class);
    }

    @Override
    public UsdaFoodSource findByUsdaFoodIdAndFoodAndSource(int usdaFoodId, Food food, Source source)
    {
        String qlString = "select o from " + type.getName()
                + " o where o.usdaFoodId = :usdaFoodId and o.food.id = :foodId and o.source.id = :sourceId";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("usdaFoodId", usdaFoodId);
        query.setParameter("foodId", food.getId());
        query.setParameter("sourceId", source.getId());
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<UsdaFoodSource> usdaFoodSources = query.getResultList();
        return usdaFoodSources.isEmpty() ? null : usdaFoodSources.get(0);
    }
}