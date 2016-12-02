package com.wet.api.nutrition.dao.driver;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.dao.FoodDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.FoodGroup;

public class FoodDaoTestDriver
{	
	private FoodDao foodDao;
	
	public void run()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
		foodDao = (FoodDao)context.getBean("foodDaoJpa");
		Food food = save();
		update(food);
		context.close();
		
		System.out.println(food);
	}

	private Food save()
	{
		FoodGroup foodGroup = new FoodGroup();
		foodGroup.setName("Test Food Group For Test Food");
		foodGroup.setCreateDate(new Date());
		
		Food food = new Food();
		food.setName("Test Food");
		food.setFoodGroup(foodGroup);
		food.setCreateDate(new Date());
		foodDao.save(food);

		return food;
	}
	
	private void update(Food food)
	{
		Food foundFood = foodDao.find(food.getId());
		foundFood.setName("Updated Food");
		
		FoodGroup foundFoodGroup = foundFood.getFoodGroup();
		foundFoodGroup.setName("Updated Food Group For Test Food");
		
		foundFood.setFoodGroup(foundFoodGroup);
		foodDao.save(foundFood);
	}
	
	public static void main(String[] args) 
	{
		FoodDaoTestDriver testDriver = new FoodDaoTestDriver();
		testDriver.run();
	}
}