package com.wet.api.nutrition.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.NutrientGroupDao;
import com.wet.api.nutrition.model.NutrientGroup;

@Repository
public class NutrientGroupDaoJpa extends AbstractNutritionDaoJpa<NutrientGroup> implements NutrientGroupDao
{
    public NutrientGroupDaoJpa()
    {
        super(NutrientGroup.class);
    }

    @Override
    public NutrientGroup findByName(String name)
    {
        String qlString = "select o from " + type.getName() + " o where o.name = :name";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("name", name);
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<NutrientGroup> nutrientGroups = query.getResultList();
        return nutrientGroups.isEmpty() ? null : nutrientGroups.get(0);
    }
}