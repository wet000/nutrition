package com.wet.api.nutrition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.service.NutritionService;
import com.wet.api.nutrition.service.crawler.FoodCompositionCrawler;

@Service
public class NutritionServiceImpl implements NutritionService
{
    @Autowired
    private FoodCompositionCrawler foodCompositionCrawler;
    
    @Override
    public void crawlNutritionDatabase()
    {
        foodCompositionCrawler.crawl();
    }
}