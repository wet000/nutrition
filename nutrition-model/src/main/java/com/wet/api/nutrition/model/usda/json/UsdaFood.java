package com.wet.api.nutrition.model.usda.json;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsdaFood 
{
	@JsonProperty("ndbno")
	private int nutritionDbNumber;
	
	private String name;
	
	@JsonProperty("sd")
	private String shortDescription;
	
	@JsonProperty("fg")
	private String foodGroup;
	
	@JsonProperty("sn")
	private String scientificName;
	
	@JsonProperty("cn")
	private String commercialName;
	
	@JsonProperty("manu")
	private String manufacturer;
	
	@JsonProperty("nf")
	private double nitrogenFactor;
	
	@JsonProperty("cf")
	private double carbohydrateFactor;
	
	@JsonProperty("ff")
	private double fatFactor;
	
	@JsonProperty("pf")
	private double proteinFactor;
	
	@JsonProperty("r")
	private String refusePercent;
	
	@JsonProperty("rd")
	private String refuseDescription;
	
	@JsonProperty("ds")
	private String databaseSource;
	
	private Collection<UsdaNutrient> usdaNutrients;

	
	public int getNutritionDbNumber()
	{
		return nutritionDbNumber;
	}

	public void setNutritionDbNumber(int nutritionDbNumber)
	{
		this.nutritionDbNumber = nutritionDbNumber;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getShortDescription()
	{
		return shortDescription;
	}

	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
	}

	public String getFoodGroup()
	{
		return foodGroup;
	}

	public void setFoodGroup(String foodGroup)
	{
		this.foodGroup = foodGroup;
	}

	public String getScientificName()
	{
		return scientificName;
	}

	public void setScientificName(String scientificName)
	{
		this.scientificName = scientificName;
	}

	public String getCommercialName()
	{
		return commercialName;
	}

	public void setCommercialName(String commercialName)
	{
		this.commercialName = commercialName;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	public double getNitrogenFactor()
	{
		return nitrogenFactor;
	}

	public void setNitrogenFactor(double nitrogenFactor)
	{
		this.nitrogenFactor = nitrogenFactor;
	}

	public double getCarbohydrateFactor()
	{
		return carbohydrateFactor;
	}

	public void setCarbohydrateFactor(double carbohydrateFactor)
	{
		this.carbohydrateFactor = carbohydrateFactor;
	}

	public double getFatFactor()
	{
		return fatFactor;
	}

	public void setFatFactor(double fatFactor)
	{
		this.fatFactor = fatFactor;
	}

	public double getProteinFactor()
	{
		return proteinFactor;
	}

	public void setProteinFactor(double proteinFactor)
	{
		this.proteinFactor = proteinFactor;
	}

	public String getRefusePercent()
	{
		return refusePercent;
	}

	public void setRefusePercent(String refusePercent)
	{
		this.refusePercent = refusePercent;
	}

	public String getRefuseDescription()
	{
		return refuseDescription;
	}

	public void setRefuseDescription(String refuseDescription)
	{
		this.refuseDescription = refuseDescription;
	}

	public String getDatabaseSource()
	{
		return databaseSource;
	}

	public void setDatabaseSource(String databaseSource)
	{
		this.databaseSource = databaseSource;
	}

	public Collection<UsdaNutrient> getUsdaNutrients()
	{
		return usdaNutrients;
	}

	public void setUsdaNutrients(Collection<UsdaNutrient> usdaNutrients) 
	{
		this.usdaNutrients = usdaNutrients;
	}
}