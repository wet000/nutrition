package com.wet.api.nutrition.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.service.SourceDaoService;
import com.wet.api.nutrition.service.SourceService;

@Service
public class SourceServiceImpl implements SourceService 
{
    @Autowired
    private SourceDaoService sourceDaoService;
    
    @Override
    public Source create(String releaseVersion)
    {
        StringBuilder sourceBuilder = new StringBuilder(Source.USDA_FOOD_COMPOSITION);
        sourceBuilder.append(" Release Version ").append(releaseVersion);

        Source source = sourceDaoService.findBySource(sourceBuilder.toString());
        if (source == null)
        {
            System.out.println("Couldn't find source \"" + sourceBuilder.toString() + "\" so creating...");
            source = new Source();
            source.setSource(sourceBuilder.toString());
            source.setCreateDate(new Date());
            sourceDaoService.save(source);
        }
        else
        {
            System.out.println("Found source \"" + source + "\"");
        }
        
        return source;
    }
}