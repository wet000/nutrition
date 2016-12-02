package com.wet.api.nutrition.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.wet.api.common.model.DomainEntity;


/**
 * The persistent class for the nutrition_fact database table.
 * 
 */
@Entity
@Table(name="nutrition_fact")
@NamedQuery(name="NutritionFact.findAll", query="SELECT n FROM NutritionFact n")
public class NutritionFact implements DomainEntity
{
	private static final long serialVersionUID = -6096624187585205525L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="food_id")
	private Food food;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="nutrient_id")
	private Nutrient nutrient;
	
	@Column(name="label")
	private String label;

	@Column(name="serving_size")
	private short servingSize;
	
	@Column(name="amount_per_serving")
	private BigDecimal amountPerServing;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	private Date version;
	
	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Nutrient getNutrient() {
		return this.nutrient;
	}

	public void setNutrient(Nutrient nutrient) {
		this.nutrient = nutrient;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public short getServingSize() {
		return this.servingSize;
	}

	public void setServingSize(short servingSize) {
		this.servingSize = servingSize;
	}
	
	public BigDecimal getAmountPerServing() {
		return this.amountPerServing;
	}

	public void setAmountPerServing(BigDecimal amountPerServing) {
		this.amountPerServing = amountPerServing;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public Date getVersion() {
		return this.version;
	}

	@Override
	public void setVersion(Date version) {
		this.version = version;
	}
	
	/**
	 * Returns a string representation of a {@NutritonFact}.
	 * 
	 * @Return		the string representation of a {@NutritonFact}
	 */
	@Override
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
		StringBuilder sb = new StringBuilder("[");
		
		sb.append(this.id).append("=");
		sb.append("Food:").append(this.food).append(", ");
		sb.append("Nutrient:").append(this.nutrient).append(", ");
		sb.append("Label:").append(this.label).append(", ");
		sb.append("Serving Size:").append(this.servingSize).append(", ");
		sb.append("Amount Per Serving:").append(this.amountPerServing).append(", ");
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
	 * Equals method for {@NutritonFact}
	 * 
	 * {@NutritonFact}s are considered equal if the foods, nutrients,
	 * labels, serving sizes, and amounts per serving are equal
	 * 
	 * @param	o	the term object passed in to determine its equality with this object
	 * @return		true if this term is equal to the term passed in
	 */
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof NutritionFact) || o == null)
		{
			return false;
		}
		
		NutritionFact nutritionFact = (NutritionFact)o;
		if (this.food.equals(nutritionFact.getFood()) &&
			this.nutrient.equals(nutritionFact.getNutrient()) &&
			this.label.equals(nutritionFact.getLabel()) &&
			this.servingSize == nutritionFact.getServingSize() &&
			this.amountPerServing.equals(nutritionFact.getAmountPerServing()))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Hashcode method for {@NutritonFact}
	 * 
	 * The hashcode representation for {@NutritonFact}. The name,
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
		
		hashCode += this.food == null ? 0 : this.food.hashCode();
		hashCode += this.nutrient == null ? 0 : this.nutrient.hashCode();
		hashCode += this.label == null ? 0 : this.label.hashCode();
		hashCode += this.servingSize == 0 ? 0 : this.servingSize;
		hashCode += this.amountPerServing == null ? 0 : this.amountPerServing.hashCode();
		
		return hashCode;
	}
}