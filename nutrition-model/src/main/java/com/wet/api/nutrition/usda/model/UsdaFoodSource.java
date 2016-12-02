package com.wet.api.nutrition.usda.model;

import javax.persistence.*;

import com.wet.api.common.model.DomainEntity;
import com.wet.api.nutrition.model.Food;
import com.wet.api.nutrition.model.Source;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The persistent class for the usda_food_source database table.
 * 
 */
@Entity
@Table(name="usda_food_source")
@NamedQuery(name="UsdaFoodSource.findAll", query="SELECT u FROM UsdaFoodSource u")
public class UsdaFoodSource implements DomainEntity 
{
	private static final long serialVersionUID = 1617258391248664916L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="usda_food_id")
	private int usdaFoodId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="food_id")
	private Food food;
	
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
	
	public int getUsdaFoodId() 
	{
		return this.usdaFoodId;
	}

	public void setUsdaFoodId(int usdaFoodId) 
	{
		this.usdaFoodId = usdaFoodId;
	}

	public Food getFood() 
	{
		return this.food;
	}

	public void setFood(Food food) 
	{
		this.food = food;
	}

	public Source getSource() 
	{
		return this.source;
	}

	public void setSource(Source source) {
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
	 * Returns a string representation of a {@UsdaFoodSource}.
	 * 
	 * @Return		the string representation of a {@UsdaFoodSource}
	 */
	@Override
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
		StringBuilder sb = new StringBuilder("[");
		
		sb.append(this.id).append("=");
		sb.append("USDA Food Id:").append(this.usdaFoodId).append(", ");
		sb.append("Food:").append(this.food).append(", ");
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
	 * Equals method for {@UsdaFoodSource}
	 * 
	 * {@UsdaFoodSource}s are considered equal if the USDA Food Ids, 
	 * foods, and sources equal
	 * 
	 * @param	o	the term object passed in to determine its equality with this object
	 * @return		true if this term is equal to the term passed in
	 */
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof UsdaFoodSource) || o == null)
		{
			return false;
		}
		
		UsdaFoodSource usdaFoodSource = (UsdaFoodSource)o;
		if (this.usdaFoodId == usdaFoodSource.getUsdaFoodId() &&
			this.food.equals(usdaFoodSource.getFood()) &&
			this.source.equals(usdaFoodSource.getSource()))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Hashcode method for {@UsdaFoodSource}
	 * 
	 * The hashcode representation for {@UsdaFoodSource}. The USDA Food Id,
	 * food, and source are used to determine the hashcode value.
	 * 
	 * @return		the hashcode value
	 */
	@Override
	public int hashCode()
	{
		int hashCode = 31;
		
		hashCode += this.usdaFoodId == 0 ? 0 : this.usdaFoodId;
		hashCode += this.food == null ? 0 : this.food.hashCode();
		hashCode += this.source == null ? 0 : this.source.hashCode();
		
		return hashCode;
	}
}