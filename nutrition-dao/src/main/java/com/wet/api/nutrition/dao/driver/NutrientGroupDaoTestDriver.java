package com.wet.api.nutrition.dao.driver;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.dao.NutrientGroupDao;
import com.wet.api.nutrition.model.NutrientGroup;

public class NutrientGroupDaoTestDriver
{
    private NutrientGroupDao nutrientGroupDao;

    public void run()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
        nutrientGroupDao = (NutrientGroupDao) context.getBean("nutrientGroupDaoJpa");
        NutrientGroup nutrientGroup = save();
        update(nutrientGroup);
        context.close();

        System.out.println(nutrientGroup);
    }

    private NutrientGroup save()
    {
        NutrientGroup nutrientGroup = new NutrientGroup();
        nutrientGroup.setName("Test Nutrient Group");
        nutrientGroup.setCreateDate(new Date());
        nutrientGroupDao.save(nutrientGroup);

        return nutrientGroup;
    }

    private void update(NutrientGroup nutrientGroup)
    {
        NutrientGroup foundNutrientGroup = nutrientGroupDao.find(nutrientGroup.getId());
        foundNutrientGroup.setName("Updated Test Nutrient Group");
        nutrientGroupDao.save(foundNutrientGroup);
    }

    public static void main(String[] args)
    {
        NutrientGroupDaoTestDriver testDriver = new NutrientGroupDaoTestDriver();
        testDriver.run();
    }
}