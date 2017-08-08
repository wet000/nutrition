package com.wet.api.nutrition.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.FoodGroup;
import com.wet.api.nutrition.service.FoodGroupDaoService;
import com.wet.api.nutrition.service.FoodGroupService;

@Service
public class FoodGroupServiceImpl implements FoodGroupService
{
    @Autowired
    private FoodGroupDaoService foodGroupDaoService;

    @Override
    public FoodGroup findFoodGroup(String foodGroupName)
    {
        FoodGroup foodGroup = foodGroupDaoService.findByName(foodGroupName);
        if (foodGroup == null)
        {
            System.out.println("Couldn't find food group: " + foodGroupName);
            foodGroup = new FoodGroup();
            foodGroup.setName(foodGroupName);
            foodGroup.setCreateDate(new Date());
            foodGroupDaoService.save(foodGroup);
        }
        else
        {
            System.out.println("Found food group: " + foodGroup);
        }
        
        return foodGroup;
    }
}
