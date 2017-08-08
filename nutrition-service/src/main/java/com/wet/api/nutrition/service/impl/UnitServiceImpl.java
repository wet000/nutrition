package com.wet.api.nutrition.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.Unit;
import com.wet.api.nutrition.service.UnitDaoService;
import com.wet.api.nutrition.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService
{
    @Autowired
    private UnitDaoService unitDaoService;
    
    @Override
    public Unit create(String abbreviation)
    {
        Unit unit = unitDaoService.findByNameAndAbbreviation(abbreviation);
        if (unit == null)
        {
            System.out.println("Couldn't find unit: " + abbreviation);
            unit = new Unit();
            unit.setName("NEED TO SET NAME MANUALLY");
            unit.setAbbreviation(abbreviation);
            unit.setCreateDate(new Date());
            unitDaoService.save(unit);
        }
        else
        {
            System.out.println("Found unit: " + unit);
        }
        
        return unit;
    }
}
