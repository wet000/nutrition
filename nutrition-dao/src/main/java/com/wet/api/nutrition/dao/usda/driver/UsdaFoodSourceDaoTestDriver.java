package com.wet.api.nutrition.dao.usda.driver;

import java.util.Date;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.dao.usda.UsdaFoodSourceDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.FoodGroup;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.UsdaFoodSource;

public class UsdaFoodSourceDaoTestDriver
{
    private UsdaFoodSourceDao usdaFoodSourceDao;

    public void run()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
        usdaFoodSourceDao = (UsdaFoodSourceDao) context.getBean("usdaFoodSourceDaoJpa");
        UsdaFoodSource usdaFoodSource = save();
        update(usdaFoodSource);
        context.close();

        System.out.println(usdaFoodSource);
    }

    private UsdaFoodSource save()
    {
        FoodGroup foodGroup = new FoodGroup();
        foodGroup.setName("Test Food Group For Test Usda Food Source");
        foodGroup.setCreateDate(new Date());

        Food food = new Food();
        food.setName("Test Food For Test Usda Food Source");
        food.setFoodGroup(foodGroup);
        food.setCreateDate(new Date());

        Source source = new Source();
        source.setSource("Test Source For Test Usda Food Source");
        source.setCreateDate(new Date());

        UsdaFoodSource usdaFoodSource = new UsdaFoodSource();
        usdaFoodSource.setUsdaFoodId(new Random().nextInt(10000));
        usdaFoodSource.setFood(food);
        usdaFoodSource.setSource(source);
        usdaFoodSource.setCreateDate(new Date());
        usdaFoodSourceDao.save(usdaFoodSource);

        return usdaFoodSource;
    }

    private void update(UsdaFoodSource usdaFoodSource)
    {
        UsdaFoodSource foundUsdaFoodSource = usdaFoodSourceDao.find(usdaFoodSource.getId());
        Food foundFood = foundUsdaFoodSource.getFood();
        FoodGroup foundFoodGroup = foundFood.getFoodGroup();
        Source foundSource = foundUsdaFoodSource.getSource();

        foundFoodGroup.setName("Updated Food Group For Test USDA Food Source");
        foundFood.setName("Updated Food For Test USDA Food Source");
        foundFood.setFoodGroup(foundFoodGroup);
        foundSource.setSource("Updated Test Source For Test USDA Food Source");

        foundUsdaFoodSource.setFood(foundFood);
        foundUsdaFoodSource.setSource(foundSource);
        foundUsdaFoodSource.setUsdaFoodId(new Random().nextInt(10000));

        usdaFoodSourceDao.save(foundUsdaFoodSource);
    }

    public static void main(String[] args)
    {
        UsdaFoodSourceDaoTestDriver testDriver = new UsdaFoodSourceDaoTestDriver();
        testDriver.run();
    }
}