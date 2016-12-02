package com.wet.api.nutrition.model;

import javax.persistence.*;

import com.wet.api.common.model.DomainEntity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The persistent class for the nutrient database table.
 * 
 */
@Entity
@NamedQuery(name="Nutrient.findAll", query="SELECT n FROM Nutrient n")
public class Nutrient implements DomainEntity 
{
	private static final long serialVersionUID = -4613582126619053385L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="name")
	private String name;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="nutrient_group_id")
	private NutrientGroup nutrientGroup;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="unit_of_measurement_id")
	private UnitOfMeasurement unitOfMeasurement;

	@Column(name="recommended_dietary_allowance")
	private BigDecimal recommendedDietaryAllowance;

	@Column(name="overdose_limit")
	private BigDecimal overdoseLimit;

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
	
	public NutrientGroup getNutrientGroup()
	{
		return this.nutrientGroup;
	}

	public void setNutrientGroup(NutrientGroup nutrientGroup) 
	{
		this.nutrientGroup = nutrientGroup;
	}
	
	public UnitOfMeasurement getUnitOfMeasurement()
	{
		return this.unitOfMeasurement;
	}

	public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) 
	{
		this.unitOfMeasurement = unitOfMeasurement;
	}
	
	public BigDecimal getRecommendedDietaryAllowance()
	{
		return this.recommendedDietaryAllowance;
	}

	public void setRecommendedDietaryAllowance(BigDecimal recommendedDietaryAllowance) 
	{
		this.recommendedDietaryAllowance = recommendedDietaryAllowance;
	}
	
	public BigDecimal getOverdoseLimit() 
	{
		return this.overdoseLimit;
	}

	public void setOverdoseLimit(BigDecimal overdoseLimit) 
	{
		this.overdoseLimit = overdoseLimit;
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
	 * Returns a string representation of a {@Nutrient}.
	 * 
	 * @Return		the string representation of a {@Nutrient}
	 */
	@Override
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
		StringBuilder sb = new StringBuilder("[");
		
		sb.append(this.id).append("=");
		sb.append("Name:").append(this.name).append(", ");
		sb.append("Nutrient Group:").append(this.nutrientGroup).append(", ");
		sb.append("Unit of Measurement:").append(this.unitOfMeasurement).append(", ");
		sb.append("Recommended Dietary Allowance:").append(this.recommendedDietaryAllowance).append(", ");
		sb.append("Overdose Limit:").append(this.overdoseLimit).append(", ");
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
	 * Equals method for {@Nutrient}
	 * 
	 * {@Nutrient}s are considered equal if the names, nutrient groups,
	 * unit of measurements, recommended dietary allowances, and 
	 * overdose limits are equal
	 * 
	 * @param	o	the term object passed in to determine its equality with this object
	 * @return		true if this term is equal to the term passed in
	 */
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Nutrient) || o == null)
		{
			return false;
		}
		
		Nutrient nutrient = (Nutrient)o;
		if (this.name.equals(nutrient.getName()) &&
			this.nutrientGroup.equals(nutrient.getNutrientGroup()) &&
			this.unitOfMeasurement.equals(nutrient.getUnitOfMeasurement()) &&
			this.recommendedDietaryAllowance.equals(nutrient.getRecommendedDietaryAllowance()) &&
			this.overdoseLimit.equals(nutrient.getOverdoseLimit()))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Hashcode method for {@Nutrient}
	 * 
	 * The hashcode representation for {@Nutrient}. The name,
	 * nutrient group, unit of measurement, recommended dietary
	 * allowance and overdose limit are used to determine the
	 * hashcode value.
	 * 
	 * @return		the hashcode value
	 */
	@Override
	public int hashCode()
	{
		int hashCode = 31;
		
		hashCode += this.name == null ? 0 : this.name.hashCode();
		hashCode += this.nutrientGroup == null ? 0 : this.nutrientGroup.hashCode();
		hashCode += this.unitOfMeasurement == null ? 0 : this.unitOfMeasurement.hashCode();
		hashCode += this.recommendedDietaryAllowance == null ? 0 : this.recommendedDietaryAllowance.hashCode();
		hashCode += this.overdoseLimit == null ? 0 : this.overdoseLimit.hashCode();
		
		return hashCode;
	}
}