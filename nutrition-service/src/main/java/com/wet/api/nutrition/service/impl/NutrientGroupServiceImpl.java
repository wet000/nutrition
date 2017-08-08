package com.wet.api.nutrition.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.NutrientGroup;
import com.wet.api.nutrition.service.NutrientGroupDaoService;
import com.wet.api.nutrition.service.NutrientGroupService;

@Service
public class NutrientGroupServiceImpl implements NutrientGroupService
{
    @Autowired
    private NutrientGroupDaoService nutrientGroupServiceDao;
    
    @Override
    public NutrientGroup create(String nutrientGroupName)
    {
        NutrientGroup nutrientGroup = nutrientGroupServiceDao.findByName(nutrientGroupName);
        if (nutrientGroup == null)
        {
            System.out.println("Couldn't find nutrient group: " + nutrientGroupName);
            nutrientGroup = new NutrientGroup();
            nutrientGroup.setName(nutrientGroupName);
            nutrientGroup.setCreateDate(new Date());
            nutrientGroupServiceDao.save(nutrientGroup);
        }
        else
        {
            System.out.println("Found nutrient group: " + nutrientGroup);
        }
        
        return nutrientGroup;
    }
}