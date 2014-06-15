package org.seadva.registry.database.model.obj.vaRegistry;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import org.hibernate.proxy.HibernateProxy;
import org.seadva.registry.database.model.obj.vaRegistry.iface.IProperty;


/** 
 * Object mapping for hibernate-handled table: property.
 * @author autogenerated
 */

@Entity
@Table(name = "property", catalog = "va_registry")
public class Property implements Cloneable, Serializable, IPojoGenEntity, IProperty {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559002627L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private BaseEntity entity;
	/** Field mapping. */
	private Long id = 0L; // init for hibernate bug workaround
	/** Field mapping. */
    @Expose
	private MetadataType metadata;
	/** Field mapping. */
    @Expose
	private String valuestr;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Property() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Property(Long id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param entity BaseEntity object;
	 * @param id Long object;
	 * @param metadata MetadataType object;
	 * @param valuestr String object;
	 */
	public Property(BaseEntity entity, Long id, MetadataType metadata,
			String valuestr) {

		this.entity = entity;
		this.id = id;
		this.metadata = metadata;
		this.valuestr = valuestr;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Property.class;
	}
 

    /**
     * Return the value associated with the column: entity.
	 * @return A BaseEntity object (this.entity)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@JoinColumn(name = "entity_id", nullable = false )
	public BaseEntity getEntity() {
		return this.entity;
		
	}
	

  
    /**  
     * Set the value related to the column: entity.
	 * @param entity the entity value you wish to set
	 */
	public void setEntity(final BaseEntity entity) {
		this.entity = entity;
	}

    /**
     * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic( optional = false )
	@Column( name = "property_id", nullable = false  )
	public Long getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Long id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0L) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: metadata.
	 * @return A MetadataType object (this.metadata)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@JoinColumn(name = "metadata_id", nullable = false )
	public MetadataType getMetadata() {
		return this.metadata;
		
	}
	

  
    /**  
     * Set the value related to the column: metadata.
	 * @param metadata the metadata value you wish to set
	 */
	public void setMetadata(final MetadataType metadata) {
		this.metadata = metadata;
	}

    /**
     * Return the value associated with the column: valuestr.
	 * @return A String object (this.valuestr)
	 */
	@Basic( optional = false )
	@Column( nullable = false, length = 127  )
	public String getValuestr() {
		return this.valuestr;
		
	}
	

  
    /**  
     * Set the value related to the column: valuestr.
	 * @param valuestr the valuestr value you wish to set
	 */
	public void setValuestr(final String valuestr) {
		this.valuestr = valuestr;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Property clone() throws CloneNotSupportedException {
		
        final Property copy = (Property)super.clone();

		copy.setEntity(this.getEntity());
		copy.setId(this.getId());
		copy.setMetadata(this.getMetadata());
		copy.setValuestr(this.getValuestr());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId() + ", ");
		sb.append("valuestr: " + this.getValuestr());
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see Object#equals(Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final Property that; 
		try {
			that = (Property) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getEntity() == null) && (that.getEntity() == null)) || (getEntity() != null && getEntity().getId().equals(that.getEntity().getId())));
		result = result && (((getMetadata() == null) && (that.getMetadata() == null)) || (getMetadata() != null && getMetadata().getId().equals(that.getMetadata().getId())));	
		result = result && (((getValuestr() == null) && (that.getValuestr() == null)) || (getValuestr() != null && getValuestr().equals(that.getValuestr())));
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					Long newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0L) {
							newHashCode = getId();
						} else {
							newHashCode = (long) super.hashCode();

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
		return (int) (this.hashCode & 0xffffff);
	}
	

	
}
