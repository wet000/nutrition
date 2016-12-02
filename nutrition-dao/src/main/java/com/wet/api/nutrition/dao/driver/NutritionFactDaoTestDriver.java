package com.wet.api.nutrition.dao.driver;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.dao.NutritionFactDao;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.FoodGroup;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.NutrientGroup;
import com.wet.api.nutrition.model.NutritionFact;
import com.wet.api.nutrition.model.UnitOfMeasurement;

public class NutritionFactDaoTestDriver
{	
	private NutritionFactDao nutritionFactDao;
	
	public void run()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
		nutritionFactDao = (NutritionFactDao)context.getBean("nutritionFactDaoJpa");
		NutritionFact nutritionFact = save();
		update(nutritionFact);
		context.close();
		
		System.out.println(nutritionFact);
	}

	private NutritionFact save()
	{
		NutrientGroup nutrientGroup = new NutrientGroup();
		nutrientGroup.setName("Test Nutrient Group For Test Nutrition Fact");
		nutrientGroup.setCreateDate(new Date());
		
		UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
		unitOfMeasurement.setName("Test Unit Of Measurement For Test Nutrition Fact");
		unitOfMeasurement.setAbbreviation("TUOMFTN");
		unitOfMeasurement.setCreateDate(new Date());
		
		Nutrient nutrient = new Nutrient();
		nutrient.setName("Test Nutrient For Test Nutrition Fact");
		nutrient.setNutrientGroup(nutrientGroup);
		nutrient.setUnitOfMeasurement(unitOfMeasurement);
		nutrient.setRecommendedDietaryAllowance(new BigDecimal(100.2));
		nutrient.setOverdoseLimit(new BigDecimal(1000.5));
		nutrient.setCreateDate(new Date());
		
		FoodGroup foodGroup = new FoodGroup();
		foodGroup.setName("Test Food Group For Test Nutrition Fact");
		foodGroup.setCreateDate(new Date());
		
		Food food = new Food();
		food.setName("Test Food For Test Nutrition Fact");
		food.setFoodGroup(foodGroup);
		food.setCreateDate(new Date());
		
		NutritionFact nutritionFact = new NutritionFact();
		nutritionFact.setFood(food);
		nutritionFact.setNutrient(nutrient);
		nutritionFact.setLabel("Test Label");
		nutritionFact.setServingSize((short)10);
		nutritionFact.setAmountPerServing(new BigDecimal(50.2d));
		nutritionFact.setCreateDate(new Date());
		
		nutritionFactDao.save(nutritionFact);

		return nutritionFact;
	}
	
	private void update(NutritionFact nutritionFact)
	{
		NutritionFact foundNutritionFact = nutritionFactDao.find(nutritionFact.getId());
		Food foundFood = foundNutritionFact.getFood();
		FoodGroup foundFoodGroup = foundFood.getFoodGroup();
		Nutrient foundNutrient = foundNutritionFact.getNutrient();
		NutrientGroup foundNutrientGroup = foundNutrient.getNutrientGroup();
		UnitOfMeasurement foundUnitOfMeasurement = foundNutrient.getUnitOfMeasurement();

		foundFoodGroup.setName("Updated Food Group For Test Nutrition Fact");
		
		foundFood.setName("Updated Food For Test Nutrition Fact");
		foundFood.setFoodGroup(foundFoodGroup);
		
		foundNutrientGroup.setName("Updated Nutrient Group For Test Nutrition Fact");
		foundUnitOfMeasurement.setName("Updated Unit Of Measurement For Test Nutrition Fact");
		foundUnitOfMeasurement.setAbbreviation("UUOMFTNF");
		
		foundNutrient.setName("Updated Nutrient For Nutrition Fact");
		foundNutrient.setNutrientGroup(foundNutrientGroup);
		foundNutrient.setUnitOfMeasurement(foundUnitOfMeasurement);
		foundNutrient.setRecommendedDietaryAllowance(new BigDecimal(101.2));
		foundNutrient.setOverdoseLimit(new BigDecimal(1001.5));
		
		foundNutritionFact.setFood(foundFood);
		foundNutritionFact.setNutrient(foundNutrient);
		foundNutritionFact.setLabel("Updated Label");
		foundNutritionFact.setServingSize((short)11);
		foundNutritionFact.setAmountPerServing(new BigDecimal(51.3));
		
		nutritionFactDao.save(foundNutritionFact);
	}
	
	public static void main(String[] args) 
	{
		NutritionFactDaoTestDriver testDriver = new NutritionFactDaoTestDriver();
		testDriver.run();
	}
}