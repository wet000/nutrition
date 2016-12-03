package com.wet.api.nutrition.model.usda.json;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsdaNutrient 
{
	@JsonProperty("nutrient_id")
	private int usdaNutrientId;
	
	private String name;
	
	private String group;
	
	private String unit;
	
	private double value;
	
	private String sourcecode;
	
	@JsonProperty("dp")
	private int dataPoints;
	
	@JsonProperty("se")
	private double standardError;
	
	private Collection<UsdaMeasure> measures;

	public int getUsdaNutrientId()
	{
		return usdaNutrientId;
	}

	public void setUsdaNutrientId(int usdaNutrientId)
	{
		this.usdaNutrientId = usdaNutrientId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGroup()
	{
		return group;
	}

	public void setGroup(String group)
	{
		this.group = group;
	}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public String getSourcecode()
	{
		return sourcecode;
	}

	public void setSourcecode(String sourcecode)
	{
		this.sourcecode = sourcecode;
	}

	public int getDataPoints()
	{
		return dataPoints;
	}

	public void setDataPoints(int dataPoints)
	{
		this.dataPoints = dataPoints;
	}

	public double getStandardError()
	{
		return standardError;
	}

	public void setStandardError(double standardError)
	{
		this.standardError = standardError;
	}

	public Collection<UsdaMeasure> getMeasures()
	{
		return measures;
	}

	public void setMeasures(Collection<UsdaMeasure> measures)
	{
		this.measures = measures;
	}
}