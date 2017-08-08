package com.wet.api.nutrition.service.usda.crawler.driver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.service.crawler.FoodCompositionCrawler;

public class UsdaFoodCompositionCrawlerTestDriver
{
	private FoodCompositionCrawler usdaFoodCompositionCrawler;
	
	public void run() 
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
		usdaFoodCompositionCrawler = (FoodCompositionCrawler)context.getBean("usdaFoodCompositionCrawlerImpl");
		
		System.out.println("Running USDA Food Composition Crawler");
		usdaFoodCompositionCrawler.crawl();
		context.close();
	}
	
	public static void main(String[] args) 
	{
		UsdaFoodCompositionCrawlerTestDriver testDriver = new UsdaFoodCompositionCrawlerTestDriver();
		testDriver.run();
	}
}