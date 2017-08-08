package com.wet.api.nutrition.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Unit;
import com.wet.api.nutrition.service.NutrientDaoService;
import com.wet.api.nutrition.service.NutrientGroupService;
import com.wet.api.nutrition.service.NutrientService;
import com.wet.api.nutrition.service.UnitService;

@Service
public class NutrientServiceImpl implements NutrientService
{
    @Autowired
    private NutrientDaoService nutrientServiceDao;

    @Autowired
    private UnitService unitService;

    @Autowired
    private NutrientGroupService nutrientGroupService;

    @Override
    public Nutrient create(String nutrientName, String nutrientGroupName, String unitName)
    {
        Unit unit = unitService.create(unitName);
        Nutrient nutrient = nutrientServiceDao.findByNameAndUnit(nutrientName, unit);
        if (nutrient == null)
        {
            System.out.println("Couldn't find nutrient: " + nutrientName);
            nutrient = new Nutrient();
            nutrient.setName(nutrientName);
            nutrient.setNutrientGroup(nutrientGroupService.create(nutrientGroupName));
            nutrient.setUnit(unit);
            nutrient.setCreateDate(new Date());
            nutrientServiceDao.save(nutrient);
        }
        else
        {
            System.out.println("Found nutrient: " + nutrient);
        }

        return nutrient;
    }
}