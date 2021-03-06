package com.wet.api.nutrition.model;

import javax.persistence.*;

import com.wet.api.common.model.DomainEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The persistent class for the unit database table.
 * 
 */
@Entity
@Table(name = "unit")
@NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")
public class Unit implements DomainEntity
{
    private static final long serialVersionUID = -3442465150579806047L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "version")
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

    public String getAbbreviation()
    {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
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
     * Returns a string representation of a {@Unit}.
     * 
     * @Return the string representation of a {@Unit}
     */
    @Override
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
        StringBuilder sb = new StringBuilder("[");

        sb.append(this.id).append("=");
        sb.append("Name:").append(this.name).append(", ");
        sb.append("Abbreviation:").append(this.abbreviation).append(", ");
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
     * Equals method for {@Unit}
     * 
     * {@Unit}s are considered equal if the names and abbreviations are equal
     * 
     * @param o the term object passed in to determine its equality with this
     *            object
     * @return true if this term is equal to the term passed in
     */
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Unit) || o == null)
        {
            return false;
        }

        Unit unit = (Unit) o;
        if (this.name.equals(unit.getName()) &&
                this.abbreviation.equals(unit.getAbbreviation()))
        {
            return true;
        }

        return false;
    }

    /**
     * Hashcode method for {@Unit}
     * 
     * The hashcode representation for {@Unit}. The name and abbreviation are
     * used to determine the hashcode value.
     * 
     * @return the hashcode value
     */
    @Override
    public int hashCode()
    {
        int hashCode = 31;

        hashCode += this.name == null ? 0 : this.name.hashCode();
        hashCode += this.abbreviation == null ? 0 : this.abbreviation.hashCode();

        return hashCode;
    }
}