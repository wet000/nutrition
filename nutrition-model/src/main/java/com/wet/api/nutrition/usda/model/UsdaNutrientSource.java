package com.wet.api.nutrition.usda.model;

import javax.persistence.*;

import com.wet.api.common.model.DomainEntity;
import com.wet.api.nutrition.model.Nutrient;
import com.wet.api.nutrition.model.Source;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The persistent class for the usda_nutrient_source database table.
 * 
 */
@Entity
@Table(name="usda_nutrient_source")
@NamedQuery(name="UsdaNutrientSource.findAll", query="SELECT u FROM UsdaNutrientSource u")
public class UsdaNutrientSource implements DomainEntity 
{
	private static final long serialVersionUID = 1677846068745563524L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="usda_nutrient_id")
	private int usdaNutrientId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="nutrient_id")
	private Nutrient nutrient;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="source_id")
	private Source source;

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

	public int getUsdaNutrientId() 
	{
		return this.usdaNutrientId;
	}

	public void setUsdaNutrientId(int usdaNutrientId) 
	{
		this.usdaNutrientId = usdaNutrientId;
	}

	public Nutrient getNutrient()
	{
		return this.nutrient;
	}

	public void setNutrient(Nutrient nutrient)
	{
		this.nutrient = nutrient;
	}

	public Source getSource()
	{
		return this.source;
	}

	public void setSource(Source source)
	{
		this.source = source;
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
	 * Returns a string representation of a {@UsdaNutrientSource}.
	 * 
	 * @Return		the string representation of a {@UsdaNutrientSource}
	 */
	@Override
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
		StringBuilder sb = new StringBuilder("[");
		
		sb.append(this.id).append("=");
		sb.append("USDA Nutrient Id:").append(this.usdaNutrientId).append(", ");
		sb.append("Nutrient:").append(this.nutrient).append(", ");
		sb.append("Source:").append(this.source).append(", ");
		
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
	 * Equals method for {@UsdaNutrientSource}
	 * 
	 * {@UsdaNutrientSource}s are considered equal if the USDA Nutrient Ids, 
	 * nutrients, and sources equal
	 * 
	 * @param	o	the term object passed in to determine its equality with this object
	 * @return		true if this term is equal to the term passed in
	 */
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof UsdaNutrientSource) || o == null)
		{
			return false;
		}
		
		UsdaNutrientSource usdaNutrientSource = (UsdaNutrientSource)o;
		if (this.usdaNutrientId == usdaNutrientSource.getUsdaNutrientId() &&
			this.nutrient.equals(usdaNutrientSource.getNutrient()) &&
			this.source.equals(usdaNutrientSource.getSource()))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Hashcode method for {@UsdaNutrientSource}
	 * 
	 * The hashcode representation for {@UsdaNutrientSource}. The USDA Nutrient Id,
	 * nutrient, and source are used to determine the hashcode value.
	 * 
	 * @return		the hashcode value
	 */
	@Override
	public int hashCode()
	{
		int hashCode = 31;
		
		hashCode += this.usdaNutrientId == 0 ? 0 : this.usdaNutrientId;
		hashCode += this.nutrient == null ? 0 : this.nutrient.hashCode();
		hashCode += this.source == null ? 0 : this.source.hashCode();
		
		return hashCode;
	}
}