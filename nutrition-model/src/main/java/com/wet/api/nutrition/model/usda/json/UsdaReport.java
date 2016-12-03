package com.wet.api.nutrition.model.usda.json;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wet.api.common.model.impl.AbstractDomainObject;

public class UsdaReport extends AbstractDomainObject 
{
	@JsonProperty("sr")
	private String releaseVersion;
	
	@JsonProperty("type")
	private String reportType;

	@JsonProperty("food")
	private UsdaFood usdaFood;
	
	@JsonProperty("sources")
	private Collection<UsdaSource> usdaSources;
	
	@JsonProperty("footnotes")
	private Collection<UsdaFootnote> usdaFootnotes;
	
	@JsonProperty("languals")
	private Collection<UsdaLangual> usdaLanguals;

	public String getReleaseVersion()
	{
		return releaseVersion;
	}
	
	public void setReleaseVersion(String releaseVersion) 
	{
		this.releaseVersion = releaseVersion;
	}

	public String getReportType() 
	{
		return reportType;
	}

	public void setReportType(String reportType) 
	{
		this.reportType = reportType;
	}

	public UsdaFood getUsdaFood() 
	{
		return usdaFood;
	}
	
	public void setUsdaFood(UsdaFood usdaFood) 
	{
		this.usdaFood = usdaFood;
	}

	public Collection<UsdaSource> getUsdaSources() 
	{
		return usdaSources;
	}
	
	public void setUsdaSources(Collection<UsdaSource> usdaSources)
	{
		this.usdaSources = usdaSources;
	}
	
	public Collection<UsdaFootnote> getUsdaFootnotes()
	{
		return usdaFootnotes;
	}

	public void setUsdaFootnotes(Collection<UsdaFootnote> usdaFootnotes)
	{
		this.usdaFootnotes = usdaFootnotes;
	}

	public Collection<UsdaLangual> getUsdaLanguals()
	{
		return usdaLanguals;
	}
	
	public void setUsdaLanguals(Collection<UsdaLangual> usdaLanguals)
	{
		this.usdaLanguals = usdaLanguals;
	}
}