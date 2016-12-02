package com.wet.api.nutrition.dao.driver;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.dao.UnitOfMeasurementDao;
import com.wet.api.nutrition.model.UnitOfMeasurement;

public class UnitOfMeasurementDaoTestDriver
{	
	private UnitOfMeasurementDao unitOfMeasurementDao;
	
	public void run()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
		unitOfMeasurementDao = (UnitOfMeasurementDao)context.getBean("unitOfMeasurementDaoJpa");
		UnitOfMeasurement unitOfMeasurement = save();
		update(unitOfMeasurement);
		context.close();
		
		System.out.println(unitOfMeasurement);
	}

	private UnitOfMeasurement save()
	{
		UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
		unitOfMeasurement.setName("Test Unit");
		unitOfMeasurement.setAbbreviation("TU");
		unitOfMeasurement.setCreateDate(new Date());
		unitOfMeasurementDao.save(unitOfMeasurement);

		return unitOfMeasurement;
	}
	
	private void update(UnitOfMeasurement unitOfMeasurement)
	{
		UnitOfMeasurement foundUnitOfMeasurement = unitOfMeasurementDao.find(unitOfMeasurement.getId());
		foundUnitOfMeasurement.setName("Updated Unit");
		foundUnitOfMeasurement.setAbbreviation("UU");
		unitOfMeasurementDao.save(foundUnitOfMeasurement);
	}
	
	public static void main(String[] args) 
	{
		UnitOfMeasurementDaoTestDriver testDriver = new UnitOfMeasurementDaoTestDriver();
		testDriver.run();
	}
}