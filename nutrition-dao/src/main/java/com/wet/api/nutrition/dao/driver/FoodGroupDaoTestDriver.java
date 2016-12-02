package com.wet.api.nutrition.dao.driver;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.dao.FoodGroupDao;
import com.wet.api.nutrition.model.FoodGroup;

public class FoodGroupDaoTestDriver
{	
	private FoodGroupDao foodGroupDao;
	
	public void run()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
		foodGroupDao = (FoodGroupDao)context.getBean("foodGroupDaoJpa");
		FoodGroup foodGroup = save();
		update(foodGroup);
		context.close();
		
		System.out.println(foodGroup);
	}

	private FoodGroup save()
	{
		FoodGroup foodGroup = new FoodGroup();
		foodGroup.setName("Test Food Group");
		foodGroup.setCreateDate(new Date());
		foodGroupDao.save(foodGroup);

		return foodGroup;
	}
	
	private void update(FoodGroup foodGroup)
	{
		FoodGroup foundFoodGroup = foodGroupDao.find(foodGroup.getId());
		foundFoodGroup.setName("Updated Test Food Group");
		foodGroupDao.save(foundFoodGroup);
	}
	
	public static void main(String[] args) 
	{
		FoodGroupDaoTestDriver testDriver = new FoodGroupDaoTestDriver();
		testDriver.run();
	}
}