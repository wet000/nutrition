package com.wet.api.nutrition.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wet.api.nutrition.dao.UnitDao;
import com.wet.api.nutrition.model.Unit;

@Repository
public class UnitDaoJpa extends AbstractNutritionDaoJpa<Unit> implements UnitDao
{
    public UnitDaoJpa()
    {
        super(Unit.class);
    }

    @Override
    public Unit findByNameAndAbbreviation(String abbreviation)
    {
        String qlString = "select o from " + type.getName() + " o where o.abbreviation = :abbreviation";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("abbreviation", abbreviation);
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<Unit> unit = query.getResultList();
        return unit.isEmpty() ? null : unit.get(0);
    }
}