package com.wet.api.nutrition.rest.driver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.model.usda.json.UsdaReport;
import com.wet.api.nutrition.rest.UsdaFoodCompositionRestClient;

public class UsdaFoodCompositionRestClientTestDriver 
{
	private UsdaFoodCompositionRestClient<UsdaReport> restClient;
	
	@SuppressWarnings("unchecked")
	public void run() 
	{
		System.out.println("Starting USDA Food Composition Rest Client Test Driver");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
		restClient = (UsdaFoodCompositionRestClient<UsdaReport>)context.getBean("usdaFoodCompositionRestClientImpl");

		UsdaReport usdaReport = restClient.getUsdaFoodReport("01009");
		
		System.out.println("Food Name: " + usdaReport.getUsdaFood().getName());
		
		context.close();
	}
	
	public static void main(String[] args) 
	{
		UsdaFoodCompositionRestClientTestDriver testDriver = new UsdaFoodCompositionRestClientTestDriver();
		testDriver.run();
	}
}