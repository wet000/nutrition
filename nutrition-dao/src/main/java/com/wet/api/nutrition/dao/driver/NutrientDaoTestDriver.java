package com.wet.api.nutrition.dao.driver;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.dao.NutrientDao;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.NutrientGroup;
import com.wet.api.nutrition.model.UnitOfMeasurement;

public class NutrientDaoTestDriver
{	
	private NutrientDao nutrientDao;
	
	public void run()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
		nutrientDao = (NutrientDao)context.getBean("nutrientDaoJpa");
		Nutrient nutrient = save();
		update(nutrient);
		context.close();
		
		System.out.println(nutrient);
	}

	private Nutrient save()
	{
		NutrientGroup nutrientGroup = new NutrientGroup();
		nutrientGroup.setName("Test Nutrient Group For Test Nutrient");
		nutrientGroup.setCreateDate(new Date());
		
		UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
		unitOfMeasurement.setName("Test Unit Of Measurement For Test Nutrient");
		unitOfMeasurement.setAbbreviation("TUOMFTN");
		unitOfMeasurement.setCreateDate(new Date());
		
		Nutrient nutrient = new Nutrient();
		nutrient.setName("Test Nutrient");
		nutrient.setNutrientGroup(nutrientGroup);
		nutrient.setUnitOfMeasurement(unitOfMeasurement);
		nutrient.setRecommendedDietaryAllowance(new BigDecimal(100.2));
		nutrient.setOverdoseLimit(new BigDecimal(1000.5));
		nutrient.setCreateDate(new Date());
		nutrientDao.save(nutrient);

		return nutrient;
	}
	
	private void update(Nutrient nutrient)
	{
		Nutrient foundNutrient = nutrientDao.find(nutrient.getId());

		NutrientGroup foundNutrientGroup = foundNutrient.getNutrientGroup();
		foundNutrientGroup.setName("Updated Nutrient Group For Test Nutrient");
		
		UnitOfMeasurement foundUnitOfMeasurement = foundNutrient.getUnitOfMeasurement();
		foundUnitOfMeasurement.setName("Updated Unit Of Measurement For Test Nutrient");
		foundUnitOfMeasurement.setAbbreviation("UUOMFTN");
		
		foundNutrient.setName("Updated Nutrient");
		foundNutrient.setNutrientGroup(foundNutrientGroup);
		foundNutrient.setUnitOfMeasurement(foundUnitOfMeasurement);
		foundNutrient.setRecommendedDietaryAllowance(new BigDecimal(101.2));
		foundNutrient.setOverdoseLimit(new BigDecimal(1001.5));
		
		nutrientDao.save(foundNutrient);
	}
	
	public static void main(String[] args) 
	{
		NutrientDaoTestDriver testDriver = new NutrientDaoTestDriver();
		testDriver.run();
	}
}