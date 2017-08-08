package com.wet.api.nutrition.model;

import javax.persistence.*;

import com.wet.api.common.model.DomainEntity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The persistent class for the food_measure database table.
 * 
 */
@Entity
@Table(name = "food_measure")
@NamedQuery(name = "FoodMeasure.findAll", query = "SELECT f FROM FoodMeasure f")
public class FoodMeasure implements DomainEntity
{
    private static final long serialVersionUID = -5190931405213495059L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "grams")
    private BigDecimal grams;

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

    public String getSize()
    {
        return this.size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    public BigDecimal getGrams()
    {
        return this.grams;
    }

    public void setGrams(BigDecimal grams)
    {
        this.grams = grams;
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
     * Returns a string representation of a {@FoodMeasure}.
     * 
     * @Return the string representation of a {@FoodMeasure}
     */
    @Override
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
        StringBuilder sb = new StringBuilder("[");

        sb.append(this.id).append("=");
        sb.append("Food:").append(this.food).append(", ");
        sb.append("Size:").append(this.size).append(", ");
        sb.append("Quantity:").append(this.quantity).append(", ");
        sb.append("Grams:").append(this.grams).append(", ");
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
     * Equals method for {@FoodMeasure}
     * 
     * {@FoodMeasure}s are considered equal if the food, size, and quantity are
     * equal
     * 
     * @param o
     *            the term object passed in to determine its equality with this
     *            object
     * @return true if this term is equal to the term passed in
     */
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof FoodMeasure) || o == null)
        {
            return false;
        }

        FoodMeasure foodMeasure = (FoodMeasure) o;
        if (this.food.equals(foodMeasure.getFood()) && 
            this.size.equals(foodMeasure.getSize()) &&
            this.quantity.equals(foodMeasure.getQuantity()))
        {
            return true;
        }

        return false;
    }

    /**
     * Hashcode method for {@FoodMeasure}
     * 
     * The hashcode representation for {@FoodMeasure}. The food, size, and quantity are used
     * to determine the hashcode value.
     * 
     * @return the hashcode value
     */
    @Override
    public int hashCode()
    {
        int hashCode = 31;

        hashCode += this.food == null ? 0 : this.food.hashCode();
        hashCode += this.size == null ? 0 : this.size.hashCode();
        hashCode += this.quantity == null ? 0 : this.quantity.hashCode();

        return hashCode;
    }
}