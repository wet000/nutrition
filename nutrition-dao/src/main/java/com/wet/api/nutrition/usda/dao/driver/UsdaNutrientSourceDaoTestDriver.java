package com.wet.api.nutrition.usda.dao.driver;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.NutrientGroup;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.UnitOfMeasurement;
import com.wet.api.nutrition.usda.dao.UsdaNutrientSourceDao;
import com.wet.api.nutrition.usda.model.UsdaNutrientSource;

public class UsdaNutrientSourceDaoTestDriver
{	
	private UsdaNutrientSourceDao usdaNutrientSourceDao;
	
	public void run()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
		usdaNutrientSourceDao = (UsdaNutrientSourceDao)context.getBean("usdaNutrientSourceDaoJpa");
		UsdaNutrientSource usdaNutrientSource = save();
		update(usdaNutrientSource);
		context.close();
		
		System.out.println(usdaNutrientSource);
	}

	private UsdaNutrientSource save()
	{
		NutrientGroup nutrientGroup = new NutrientGroup();
		nutrientGroup.setName("Test Nutrient Group For Test Usda Nutrient Source");
		nutrientGroup.setCreateDate(new Date());
		
		UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
		unitOfMeasurement.setName("Test Unit Of Measurement For Test USDA Nutrient Source");
		unitOfMeasurement.setAbbreviation("TUOMFTNS");
		unitOfMeasurement.setCreateDate(new Date());
		
		Nutrient nutrient = new Nutrient();
		nutrient.setName("Test Nutrient For Test USDA Nutrient Source");
		nutrient.setNutrientGroup(nutrientGroup);
		nutrient.setUnitOfMeasurement(unitOfMeasurement);
		nutrient.setRecommendedDietaryAllowance(new BigDecimal(100.2));
		nutrient.setOverdoseLimit(new BigDecimal(1000.5));
		nutrient.setCreateDate(new Date());
		
		Source source = new Source();
		source.setSource("Test Source For Test Usda Nutrient Source");
		source.setCreateDate(new Date());
		
		UsdaNutrientSource usdaNutrientSource = new UsdaNutrientSource();
		usdaNutrientSource.setUsdaNutrientId(new Random().nextInt(10000));
		usdaNutrientSource.setNutrient(nutrient);
		usdaNutrientSource.setSource(source);
		usdaNutrientSource.setCreateDate(new Date());
		usdaNutrientSourceDao.save(usdaNutrientSource);
		
		return usdaNutrientSource;
	}
	
	private void update(UsdaNutrientSource usdaNutrientSource)
	{
		UsdaNutrientSource foundUsdaNutrientSource = usdaNutrientSourceDao.find(usdaNutrientSource.getId());
		Nutrient foundNutrient = foundUsdaNutrientSource.getNutrient();
		NutrientGroup foundNutrientGroup = foundNutrient.getNutrientGroup();
		UnitOfMeasurement foundUnitOfMeasurement = foundNutrient.getUnitOfMeasurement();
		Source foundSource = foundUsdaNutrientSource.getSource();
		
		foundNutrientGroup.setName("Updated Nutrient Group For Test USDA Nutrient Source");
		foundUnitOfMeasurement.setName("Updated Unit Of Measurement For Test USDA Nutrient Source");
		foundUnitOfMeasurement.setAbbreviation("UUOMFTUNS");
		
		foundNutrient.setName("Updated Nutrient For USDA Nutrient Source");
		foundNutrient.setNutrientGroup(foundNutrientGroup);
		foundNutrient.setUnitOfMeasurement(foundUnitOfMeasurement);
		foundNutrient.setRecommendedDietaryAllowance(new BigDecimal(101.2));
		foundNutrient.setOverdoseLimit(new BigDecimal(1001.5));
		
		foundUsdaNutrientSource.setNutrient(foundNutrient);
		foundUsdaNutrientSource.setSource(foundSource);
		foundUsdaNutrientSource.setUsdaNutrientId(new Random().nextInt(10000));

		usdaNutrientSourceDao.save(foundUsdaNutrientSource);
	}
	
	public static void main(String[] args) 
	{
		UsdaNutrientSourceDaoTestDriver testDriver = new UsdaNutrientSourceDaoTestDriver();
		testDriver.run();
	}
}