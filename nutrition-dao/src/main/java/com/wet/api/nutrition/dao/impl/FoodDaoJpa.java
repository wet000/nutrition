package com.wet.api.nutrition.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.FoodDao;
import com.wet.api.nutrition.model.Food;

@Repository
public class FoodDaoJpa extends AbstractNutritionDaoJpa<Food> implements FoodDao
{
    public FoodDaoJpa()
    {
        super(Food.class);
    }

    @Override
    public Food findByName(String name)
    {
        String qlString = "select o from " + type.getName() + " o where o.name = :name";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("name", name);
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<Food> foods = query.getResultList();
        return foods.isEmpty() ? null : foods.get(0);
    }
}