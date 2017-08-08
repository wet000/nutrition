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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="name")
	private String name;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="nutrient_group_id")
	private NutrientGroup nutrientGroup;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="unit_id")
	private Unit unit;

	@Column(name="recommended_dietary_allowance")
	private BigDecimal recommendedDietaryAllowance = BigDecimal.ZERO;

	@Column(name="overdose_limit")
	private BigDecimal overdoseLimit = BigDecimal.ZERO;

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
	
	public Unit getUnit()
	{
		return this.unit;
	}

	public void setUnit(Unit unit) 
	{
		this.unit = unit;
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
		sb.append("Unit:").append(this.unit).append(", ");
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
	 * units, recommended dietary allowances, and overdose limits are equal
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
			this.unit.equals(nutrient.getUnit()) &&
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
	 * nutrient group, unit, recommended dietary allowance, and
	 * overdose limit are used to determine the hashcode value.
	 * 
	 * @return		the hashcode value
	 */
	@Override
	public int hashCode()
	{
		int hashCode = 31;
		
		hashCode += this.name == null ? 0 : this.name.hashCode();
		hashCode += this.nutrientGroup == null ? 0 : this.nutrientGroup.hashCode();
		hashCode += this.unit == null ? 0 : this.unit.hashCode();
		hashCode += this.recommendedDietaryAllowance == null ? 0 : this.recommendedDietaryAllowance.hashCode();
		hashCode += this.overdoseLimit == null ? 0 : this.overdoseLimit.hashCode();
		
		return hashCode;
	}
}