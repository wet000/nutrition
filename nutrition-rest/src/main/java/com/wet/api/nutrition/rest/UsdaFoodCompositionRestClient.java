package com.wet.api.nutrition.rest;

import com.wet.api.nutrition.model.usda.json.UsdaReport;

public interface UsdaFoodCompositionRestClient<UsdaReportWrapper>
{
	public UsdaReport getUsdaFoodReport(String usdaFoodId);
}