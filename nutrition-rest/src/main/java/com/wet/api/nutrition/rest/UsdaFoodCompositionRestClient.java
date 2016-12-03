package com.wet.api.nutrition.rest;

import com.wet.api.common.model.DomainObject;
import com.wet.api.common.rest.RestClient;
import com.wet.api.nutrition.model.usda.json.UsdaReport;

public interface UsdaFoodCompositionRestClient<T extends DomainObject> extends RestClient<T>  
{
	public UsdaReport getUsdaFoodReport(String usdaFoodId);
}