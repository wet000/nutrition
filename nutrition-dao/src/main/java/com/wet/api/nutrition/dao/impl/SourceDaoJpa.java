package com.wet.api.nutrition.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wet.api.nutrition.dao.SourceDao;
import com.wet.api.nutrition.model.Source;

@Repository
public class SourceDaoJpa extends AbstractNutritionDaoJpa<Source> implements SourceDao
{
    public SourceDaoJpa()
    {
        super(Source.class);
    }

    @Override
    @Transactional("nutritionTransactionManager")
    public Source findBySource(String source)
    {
        String qlString = "select o from " + type.getName() + " o where o.source = :source";
        Query query = getEntityManager().createQuery(qlString, type);
        query.setParameter("source", source);
        query.setMaxResults(1);

        @SuppressWarnings("unchecked")
        List<Source> sources = query.getResultList();
        return sources.isEmpty() ? null : sources.get(0);
    }
}