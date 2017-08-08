package com.wet.api.nutrition.model;

import javax.persistence.*;

import com.wet.api.common.model.DomainEntity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The persistent class for the nutrient_group database table.
 * 
 */
@Entity
@Table(name="nutrient_group")
@NamedQuery(name="NutrientGroup.findAll", query="SELECT n FROM NutrientGroup n")
public class NutrientGroup implements DomainEntity 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="name")
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="version")
	private Date version;

	@Override
	public long getId() 
	{
		return this.id;
	}

	@Override
	public void setId(long id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getCreateDate() 
	{
		return this.createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	@Override
	public Date getVersion()
	{
		return this.version;
	}

	@Override
	public void setVersion(Date version)
	{
		this.version = version;
	}
	
	/**
	 * Returns a string representation of a {@NutrientGroup}.
	 * 
	 * @Return		the string representation of a {@NutrientGroup}
	 */
	@Override
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
		StringBuilder sb = new StringBuilder("[");
		
		sb.append(this.id).append("=");
		sb.append("Name:").append(this.name).append(", ");
		sb.append("Created:").append(formatter.format(this.createDate)).append(", ");
		
		// Last Modified
		if (this.version == null)
		{
			sb.append("Not Saved");
		}
		else
		{
			sb.append("Version:").append(formatter.format(this.version));
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	/**
	 * Equals method for {@NutrientGroup}
	 * 
	 * {@NutrientGroup}s are considered equal if the names of the nutrient groups are equal
	 * 
	 * @param	o	the term object passed in to determine its equality with this object
	 * @return		true if this term is equal to the term passed in
	 */
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof NutrientGroup) || o == null)
		{
			return false;
		}
		
		NutrientGroup nutrientGroup = (NutrientGroup)o;
		if (this.name.equals(nutrientGroup.getName()))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Hashcode method for {@FoodGroup}
	 * 
	 * The hashcode representation for {@FoodGroup}. The name is used
	 * to determine the hashcode value.
	 * 
	 * @return		the hashcode value
	 */
	@Override
	public int hashCode()
	{
		int hashCode = 31;
		
		hashCode += this.name == null ? 0 : this.name.hashCode();
		
		return hashCode;
	}
}