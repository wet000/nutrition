package com.wet.api.nutrition.model.usda.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsdaLangual 
{
	@JsonProperty("code")
	private String langualCode;

	@JsonProperty("desc")
	private String description;

	public String getLangualCode()
	{
		return langualCode;
	}

	public void setLangualCode(String langualCode)
	{
		this.langualCode = langualCode;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}