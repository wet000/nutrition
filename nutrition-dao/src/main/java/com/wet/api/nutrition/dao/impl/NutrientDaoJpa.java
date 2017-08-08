package com.wet.api.nutrition.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.NutrientDao;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Unit;

@Repository
public class NutrientDaoJpa extends AbstractNutritionDaoJpa<Nutrient> implements NutrientDao
{
    public NutrientDaoJpa()
    {
        super(Nutrient.class);
    }

    @Override
    public Nutrient findByNameAndUnit(String name, Unit unit)
    {
        String qlString = "select o from " + type.getName() + " o where o.name = :name and o.unit.id = :unitId";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("name", name);
        query.setParameter("unitId", unit.getId());
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<Nutrient> nutrients = query.getResultList();
        return nutrients.isEmpty() ? null : nutrients.get(0);
    }
}