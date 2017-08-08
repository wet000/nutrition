package com.wet.api.nutrition.service.crawler.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.model.usda.json.UsdaFood;
import com.wet.api.nutrition.model.usda.json.UsdaMeasure;
import com.wet.api.nutrition.model.usda.json.UsdaNutrient;
import com.wet.api.nutrition.model.usda.json.UsdaReport;
import com.wet.api.nutrition.model.usda.json.UsdaReportWrapper;
import com.wet.api.nutrition.rest.UsdaFoodCompositionRestClient;
import com.wet.api.nutrition.service.FoodMeasureService;
import com.wet.api.nutrition.service.FoodService;
import com.wet.api.nutrition.service.NutrientMeasureService;
import com.wet.api.nutrition.service.NutrientService;
import com.wet.api.nutrition.service.SourceService;
import com.wet.api.nutrition.service.crawler.FoodCompositionCrawler;
import com.wet.api.nutrition.service.usda.UsdaFoodSourceService;
import com.wet.api.nutrition.service.usda.UsdaNutrientSourceService;

@Service
public class UsdaFoodCompositionCrawler implements FoodCompositionCrawler
{

    private static final int USDA_NUTRIENT_NUMBER_GRAMS = 100;
    private static final int USDA_FOOD_ID_START = 1001;
    // private static final int USDA_FOOD_ID_START = 1051;
    private static final int USDA_FOOD_ID_END = 5320;

    @Autowired
    private FoodService foodService;

    @Autowired
    private NutrientService nutrientService;

    @Autowired
    private FoodMeasureService foodMeasureService;

    @Autowired
    private NutrientMeasureService nutrientMeasureService;

    @Autowired
    private SourceService sourceService;

    @Autowired
    private UsdaFoodSourceService usdaFoodSourceService;

    @Autowired
    private UsdaNutrientSourceService usdaNutrientSourceService;

    @Autowired
    private UsdaFoodCompositionRestClient<UsdaReportWrapper> restClient;

    @Override
    public void crawl()
    {
        // for (int i=USDA_FOOD_ID_START;i<=USDA_FOOD_ID_START+0;i++)
        for (int i = USDA_FOOD_ID_START; i <= USDA_FOOD_ID_END; i++)
        {
            System.out.println(String.format("Crawling Food ID %05d", i));
            try
            {
                UsdaReport usdaReport = restClient.getUsdaFoodReport(String.format("%05d", i));
                saveUsdaReport(usdaReport);
            }
            catch (Exception e)
            {
                System.out.println(String.format("Problem crawling Food ID %05d", i));
                System.out.println("Error: " + e.getMessage());
                continue;
            }
        }
    }

    private void saveUsdaReport(UsdaReport usdaReport)
    {
        System.out.println("Saving " + usdaReport);

        UsdaFood usdaFood = usdaReport.getUsdaFood();

        Source source = sourceService.create(usdaReport.getReleaseVersion());
        Food food = foodService.create(usdaFood.getName(), usdaFood.getFoodGroup());
        usdaFoodSourceService.saveUsdaFoodSource(usdaFood, food, source);

        for (UsdaNutrient usdaNutrient : usdaReport.getUsdaFood().getUsdaNutrients())
        {
            Nutrient nutrient = nutrientService.create(usdaNutrient.getName(), usdaNutrient.getGroup(),
                    usdaNutrient.getUnit());
            nutrientMeasureService.save(food, nutrient,
                    new BigDecimal(usdaNutrient.getValue() / USDA_NUTRIENT_NUMBER_GRAMS));
            usdaNutrientSourceService.save(usdaNutrient, nutrient, source);

            for (UsdaMeasure usdaMeasure : usdaNutrient.getMeasures())
            {
                foodMeasureService.save(food, usdaMeasure.getLabel(), new BigDecimal(usdaMeasure.getQuantity()),
                        new BigDecimal(usdaMeasure.getGrams()));
            }
        }
    }
}