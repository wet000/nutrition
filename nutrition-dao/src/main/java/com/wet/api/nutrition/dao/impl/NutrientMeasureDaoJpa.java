package com.wet.api.nutrition.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.NutrientMeasureDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.NutrientMeasure;

@Repository
public class NutrientMeasureDaoJpa extends AbstractNutritionDaoJpa<NutrientMeasure> implements NutrientMeasureDao
{
    public NutrientMeasureDaoJpa()
    {
        super(NutrientMeasure.class);
    }

    @Override
    public NutrientMeasure findByFoodAndNutrient(Food food, Nutrient nutrient)
    {
        String qlString = "select o from " + type.getName() + " o where o.food.id = :foodId and o.nutrient.id = :nutrientId";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("foodId", food.getId());
        query.setParameter("nutrientId", nutrient.getId());
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<NutrientMeasure> nutrientMeasures = query.getResultList();
        return nutrientMeasures.isEmpty() ? null : nutrientMeasures.get(0);
    }
}