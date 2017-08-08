package com.wet.api.nutrition.rest.impl;

import org.springframework.stereotype.Service;

import com.wet.api.common.rest.impl.AbstractSpringRestClient;
import com.wet.api.nutrition.model.usda.json.UsdaReport;
import com.wet.api.nutrition.model.usda.json.UsdaReportWrapper;
import com.wet.api.nutrition.rest.UsdaFoodCompositionRestClient;

@Service
public class UsdaFoodCompositionRestClientImpl extends AbstractSpringRestClient<UsdaReportWrapper> implements UsdaFoodCompositionRestClient<UsdaReportWrapper>
{
    private static final String METHOD_REPORTS = "reports";
    private static final String PARAM_USDA_FOOD_ID = "ndbno";
    private static final String PARAM_REPORT_TYPE = "type";
    private static final String PARAM_FORMAT = "format";
    private static final String PARAM_API_KEY = "api_key";

    private static final String REPORT_TYPE_FULL = "f";
    private static final String FORMAT_JSON = "json";
    private static final String API_KEY = "IzzZrz6wEbEmXUhk4vOohBmTYhgQebIQYlMR7W5v";

    private static final String BASE_URI = "http://api.nal.usda.gov/ndb/";

    @Override
    public UsdaReport getUsdaFoodReport(String usdaFoodId)
    {
        setMethod(METHOD_REPORTS);
        putParam(PARAM_USDA_FOOD_ID, usdaFoodId);
        putParam(PARAM_REPORT_TYPE, REPORT_TYPE_FULL);
        putParam(PARAM_FORMAT, FORMAT_JSON);
        putParam(PARAM_API_KEY, API_KEY);

        return get().getReport();
    }

    @Override
    protected void setType()
    {
        this.type = UsdaReportWrapper.class;
    }

    @Override
    protected void setBaseUri()
    {
        this.baseUri = BASE_URI;
    }
}