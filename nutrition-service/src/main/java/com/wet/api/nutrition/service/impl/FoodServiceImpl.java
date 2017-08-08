package com.wet.api.nutrition.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.service.FoodDaoService;
import com.wet.api.nutrition.service.FoodGroupService;
import com.wet.api.nutrition.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService
{
    @Autowired
    private FoodDaoService foodDaoService;
    
    @Autowired
    private FoodGroupService foodGroupService;
    
    @Override
    public Food create(String foodName, String foodGroupName)
    {
        Food food = foodDaoService.findByName(foodName);
        if (food == null)
        {
            System.out.println("Couldn't find food: " + foodName);
            food = new Food();
            food.setName(foodName);
            food.setFoodGroup(foodGroupService.findFoodGroup(foodGroupName));
            food.setCreateDate(new Date());
            foodDaoService.save(food);
        }
        else
        {
            System.out.println("Found food: " + food);
        }
        
        return food;
    }
}