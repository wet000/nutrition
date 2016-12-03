package com.wet.api.nutrition.model.usda.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wet.api.common.model.impl.AbstractDomainObject;

public class UsdaReportWrapper extends AbstractDomainObject
{
	@JsonProperty("report")
	private UsdaReport report;

	public UsdaReport getReport() 
	{
		return report;
	}

	public void setReport(UsdaReport report) 
	{
		this.report = report;
	}
}