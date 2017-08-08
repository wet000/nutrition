package com.wet.api.nutrition.model;

import javax.persistence.*;

import com.wet.api.common.model.DomainEntity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The persistent class for the nutrient_measure database table.
 * 
 */
@Entity
@Table(name = "nutrient_measure")
@NamedQuery(name = "NutrientMeasure.findAll", query = "SELECT n FROM NutrientMeasure n")
public class NutrientMeasure implements DomainEntity
{
    private static final long serialVersionUID = 8244069926989219013L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nutrient_id")
    private Nutrient nutrient;

    @Column(name = "amount_per_gram")
    private BigDecimal amountPerGram;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", nullable = false)
    private Date createDate;

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "version", columnDefinition = "DATETIME", nullable = false)
    private Date version;

    @Override
    public long getId()
    {
        return id;
    }

    @Override
    public void setId(long id)
    {
        this.id = id;
    }

    public Food getFood()
    {
        return this.food;
    }

    public void setFood(Food food)
    {
        this.food = food;
    }

    public Nutrient getNutrient()
    {
        return this.nutrient;
    }

    public void setNutrient(Nutrient nutrient)
    {
        this.nutrient = nutrient;
    }

    public BigDecimal getAmountPerGram()
    {
        return this.amountPerGram;
    }

    public void setAmountPerGram(BigDecimal amountPerGram)
    {
        this.amountPerGram = amountPerGram;
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
     * Returns a string representation of a {@NutrientMeasure}.
     * 
     * @Return the string representation of a {@NutrientMeasure}
     */
    @Override
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
        StringBuilder sb = new StringBuilder("[");

        sb.append(this.id).append("=");
        sb.append("Food:").append(this.food).append(", ");
        sb.append("Nutrient:").append(this.nutrient).append(", ");
        sb.append("Amount Per Gram:").append(this.amountPerGram).append(", ");
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
     * Equals method for {@NutrientMeasure}
     * 
     * {@NutrientMeasure}s are considered equal if the food and nutrient are
     * equal
     * 
     * @param o The term object passed in to determine its equality with this
     *            object
     * @return true if this term is equal to the term passed in
     */
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof NutrientMeasure) || o == null)
        {
            return false;
        }

        NutrientMeasure nutrientMeasure = (NutrientMeasure) o;
        if (this.food.equals(nutrientMeasure.getFood()) && this.nutrient.equals(nutrientMeasure.getNutrient()))
        {
            return true;
        }

        return false;
    }

    /**
     * Hashcode method for {@NutrientMeasure}
     * 
     * The hashcode representation for {@NutrientMeasure}. The food and nutrient
     * are used to determine the hashcode value.
     * 
     * @return the hashcode value
     */
    @Override
    public int hashCode()
    {
        int hashCode = 31;

        hashCode += this.food == null ? 0 : this.food.hashCode();
        hashCode += this.nutrient == null ? 0 : this.nutrient.hashCode();

        return hashCode;
    }
}