package com.wet.api.nutrition.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.wet.api.common.dao.impl.AbstractDaoJpa;
import com.wet.api.common.model.DomainEntity;

public class AbstractNutritionDaoJpa<T extends DomainEntity> extends AbstractDaoJpa<T>
{
    @PersistenceContext(unitName = "nutritionPersistenceUnit")
    private EntityManager entityManager;

    public AbstractNutritionDaoJpa(Class<T> type)
    {
        super(type);
    }

    @Override
    protected EntityManager getEntityManager()
    {
        return entityManager;
    }

    @Override
    @Transactional(value = "nutritionTransactionManager", readOnly = true)
    public T find(long id)
    {
        return super.find(id);
    }

    @Override
    @Transactional(value = "nutritionTransactionManager", readOnly = true)
    public List<T> findAll()
    {
        return super.findAll();
    }

    @Override
    @Transactional(value = "nutritionTransactionManager")
    public void save(T object)
    {
        super.save(object);
    }

    @Override
    @Transactional(value = "nutritionTransactionManager")
    public void delete(T object)
    {
        super.delete(object);
    }
}