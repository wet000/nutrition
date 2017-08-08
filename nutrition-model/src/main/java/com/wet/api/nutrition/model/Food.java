package com.wet.api.nutrition.model;

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
 * The persistent class for the food database table.
 * 
 */
@Entity
@Table(name = "food")
@NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f")
public class Food implements DomainEntity
{
    private static final long serialVersionUID = -1588670954435478452L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "food_group_id")
    private FoodGroup foodGroup;

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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public FoodGroup getFoodGroup()
    {
        return this.foodGroup;
    }

    public void setFoodGroup(FoodGroup foodGroup)
    {
        this.foodGroup = foodGroup;
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
     * Returns a string representation of a {@Food}.
     * 
     * @Return the string representation of a {@Food}
     */
    @Override
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
        StringBuilder sb = new StringBuilder("[");

        sb.append(this.id).append("=");
        sb.append("Name:").append(this.name).append(", ");
        sb.append("Food Group:").append(this.foodGroup).append(", ");
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
     * Equals method for {@Food}
     * 
     * {@Food}s are considered equal if the names and food groups are equal
     * 
     * @param o The term object passed in to determine its equality with this
     *            object
     * @return true if this term is equal to the term passed in
     */
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Food) || o == null)
        {
            return false;
        }

        Food food = (Food) o;
        if (this.name.equals(food.getName()) && this.foodGroup.equals(food.getFoodGroup()))
        {
            return true;
        }

        return false;
    }

    /**
     * Hashcode method for {@Food}
     * 
     * The hashcode representation for {@Food}. The name and food group are used
     * to determine the hashcode value.
     * 
     * @return the hashcode value
     */
    @Override
    public int hashCode()
    {
        int hashCode = 31;

        hashCode += this.name == null ? 0 : this.name.hashCode();
        hashCode += this.foodGroup == null ? 0 : this.foodGroup.hashCode();

        return hashCode;
    }
}