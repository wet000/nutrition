package com.wet.api.nutrition.model;

import javax.persistence.*;

import com.wet.api.common.model.DomainEntity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The persistent class for the source database table.
 * 
 */
@Entity
@Table(name="source")
@NamedQuery(name="Source.findAll", query="SELECT s FROM Source s")
public class Source implements DomainEntity 
{
	private static final long serialVersionUID = 2358175886226306093L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="source")
	private String source;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Version
	@Temporal(TemporalType.TIMESTAMP)
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
	
	public String getSource()
	{
		return this.source;
	}

	public void setSource(String source)
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
	 * Returns a string representation of a {@Source}.
	 * 
	 * @Return		the string representation of a {@Source}
	 */
	@Override
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ssa");
		StringBuilder sb = new StringBuilder("[");
		
		sb.append(this.id).append("=");
		sb.append("Source:").append(this.source).append(", ");
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
	 * Equals method for {@Source}
	 * 
	 * {@Source}s are considered equal if the names of the sources are equal
	 * 
	 * @param	o	the term object passed in to determine its equality with this object
	 * @return		true if this term is equal to the term passed in
	 */
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Source) || o == null)
		{
			return false;
		}
		
		Source source = (Source)o;
		if (this.source.equals(source.getSource()))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Hashcode method for {@Source}
	 * 
	 * The hashcode representation for {@Source}. The source is used
	 * to determine the hashcode value.
	 * 
	 * @return		the hashcode value
	 */
	@Override
	public int hashCode()
	{
		int hashCode = 31;
		
		hashCode += this.source == null ? 0 : this.source.hashCode();
		
		return hashCode;
	}
}