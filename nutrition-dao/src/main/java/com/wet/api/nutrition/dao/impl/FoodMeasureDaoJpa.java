package com.wet.api.nutrition.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.FoodMeasureDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.FoodMeasure;

@Repository
public class FoodMeasureDaoJpa extends AbstractNutritionDaoJpa<FoodMeasure> implements FoodMeasureDao
{
    public FoodMeasureDaoJpa()
    {
        super(FoodMeasure.class);
    }

    @Override
    public FoodMeasure findByFoodAndSizeAndQuantity(Food food, String size, BigDecimal quantity)
    {
        String qlString = "select o from " + type.getName()
                + " o where o.food.id = :foodId and o.size = :size and o.quantity = :quantity";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("foodId", food.getId());
        query.setParameter("size", size);
        query.setParameter("quantity", quantity);
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<FoodMeasure> foodMeasures = query.getResultList();
        return foodMeasures.isEmpty() ? null : foodMeasures.get(0);
    }
}