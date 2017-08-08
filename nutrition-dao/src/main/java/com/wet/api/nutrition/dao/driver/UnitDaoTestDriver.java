package com.wet.api.nutrition.dao.driver;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.dao.UnitDao;
import com.wet.api.nutrition.model.Unit;

public class UnitDaoTestDriver
{
    private UnitDao unitDao;

    public void run()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
        unitDao = (UnitDao) context.getBean("unitDaoJpa");
        Unit unit = save();
        update(unit);
        context.close();

        System.out.println(unit);
    }

    private Unit save()
    {
        Unit unit = new Unit();
        unit.setName("Test Unit");
        unit.setAbbreviation("TU");
        unit.setCreateDate(new Date());
        unitDao.save(unit);

        return unit;
    }

    private void update(Unit unit)
    {
        Unit foundUnit = unitDao.find(unit.getId());
        foundUnit.setName("Updated Unit");
        foundUnit.setAbbreviation("UU");
        unitDao.save(foundUnit);
    }

    public static void main(String[] args)
    {
        UnitDaoTestDriver testDriver = new UnitDaoTestDriver();
        testDriver.run();
    }
}