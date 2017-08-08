package com.wet.api.nutrition.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.FoodGroupDao;
import com.wet.api.nutrition.model.FoodGroup;

@Repository
public class FoodGroupDaoJpa extends AbstractNutritionDaoJpa<FoodGroup> implements FoodGroupDao
{
    public FoodGroupDaoJpa()
    {
        super(FoodGroup.class);
    }

    @Override
    public FoodGroup findByName(String name)
    {
        String qlString = "select o from " + type.getName() + " o where o.name = :name";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("name", name);
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<FoodGroup> foodGroups = query.getResultList();
        return foodGroups.isEmpty() ? null : foodGroups.get(0);
    }
}