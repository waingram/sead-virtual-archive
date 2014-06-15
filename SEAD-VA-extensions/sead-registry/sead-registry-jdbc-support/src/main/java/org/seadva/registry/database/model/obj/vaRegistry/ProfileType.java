package org.seadva.registry.database.model.obj.vaRegistry;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import org.hibernate.proxy.HibernateProxy;
import org.seadva.registry.database.model.obj.vaRegistry.AgentProfile;
import org.seadva.registry.database.model.obj.vaRegistry.iface.IProfileType;


/** 
 * Object mapping for hibernate-handled table: profile_type.
 * @author autogenerated
 */

@Entity
@Table(name = "profile_type", catalog = "va_registry")
public class ProfileType implements Cloneable, Serializable, IPojoGenEntity, IProfileType {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559002628L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, String> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, String>());
	
	/** hashCode temporary storage. */
	private volatile String hashCode;
	

	/** Field mapping. */
	//private Set<AgentProfile> agentProfiles = new HashSet<AgentProfile>();

    @Expose
	/** Field mapping. */
	private String id;

    @Expose
	/** Field mapping. */
	private String profileTypeName;

    @Expose
	/** Field mapping. */
	private String profileTypeSchema;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public ProfileType() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public ProfileType(String id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param id String object;
	 * @param profileTypeName String object;
	 * @param profileTypeSchema String object;
	 */
	public ProfileType(String id, String profileTypeName, String profileTypeSchema) {

		this.id = id;
		this.profileTypeName = profileTypeName;
		this.profileTypeSchema = profileTypeSchema;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return ProfileType.class;
	}
 

    /**
     * Return the value associated with the column: agentProfile.
	 * @return A Set&lt;AgentProfile&gt; object (this.agentProfile)
	 */
 	/*@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "id.profileType"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "profile_type_id", nullable = false  )
	public Set<AgentProfile> getAgentProfiles() {
		return this.agentProfiles;
		
	}
	
	*//**
	 * Adds a bi-directional link of type AgentProfile to the agentProfiles set.
	 * @param agentProfile item to add
	 *//*
	public void addAgentProfile(AgentProfile agentProfile) {
		agentProfile.getId().setProfileType(this);
		this.agentProfiles.add(agentProfile);
	}

  
    *//**
     * Set the value related to the column: agentProfile.
	 * @param agentProfile the agentProfile value you wish to set
	 *//*
	public void setAgentProfiles(final Set<AgentProfile> agentProfile) {
		this.agentProfiles = agentProfile;
	}
*/
    /**
     * Return the value associated with the column: id.
	 * @return A String object (this.id)
	 */
    @Id 
	@Basic( optional = false )
	@Column( name = "profile_type_id", nullable = false, length = 127  )
	public String getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final String id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: profileTypeName.
	 * @return A String object (this.profileTypeName)
	 */
	@Basic( optional = false )
	@Column( name = "profile_type_name", nullable = false, length = 127  )
	public String getProfileTypeName() {
		return this.profileTypeName;
		
	}
	

  
    /**  
     * Set the value related to the column: profileTypeName.
	 * @param profileTypeName the profileTypeName value you wish to set
	 */
	public void setProfileTypeName(final String profileTypeName) {
		this.profileTypeName = profileTypeName;
	}

    /**
     * Return the value associated with the column: profileTypeSchema.
	 * @return A String object (this.profileTypeSchema)
	 */
	@Basic( optional = false )
	@Column( name = "profile_type_schema", nullable = false, length = 256  )
	public String getProfileTypeSchema() {
		return this.profileTypeSchema;
		
	}
	

  
    /**  
     * Set the value related to the column: profileTypeSchema.
	 * @param profileTypeSchema the profileTypeSchema value you wish to set
	 */
	public void setProfileTypeSchema(final String profileTypeSchema) {
		this.profileTypeSchema = profileTypeSchema;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public ProfileType clone() throws CloneNotSupportedException {
		
        final ProfileType copy = (ProfileType)super.clone();

		/*if (this.getAgentProfiles() != null) {
			copy.getAgentProfiles().addAll(this.getAgentProfiles());
		}*/
		copy.setId(this.getId());
		copy.setProfileTypeName(this.getProfileTypeName());
		copy.setProfileTypeSchema(this.getProfileTypeSchema());
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
		sb.append("profileTypeName: " + this.getProfileTypeName() + ", ");
		sb.append("profileTypeSchema: " + this.getProfileTypeSchema());
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
		
		final ProfileType that; 
		try {
			that = (ProfileType) proxyThat;
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
		result = result && (((getProfileTypeName() == null) && (that.getProfileTypeName() == null)) || (getProfileTypeName() != null && getProfileTypeName().equals(that.getProfileTypeName())));
		result = result && (((getProfileTypeSchema() == null) && (that.getProfileTypeSchema() == null)) || (getProfileTypeSchema() != null && getProfileTypeSchema().equals(that.getProfileTypeSchema())));
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
					String newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null ) {
							newHashCode = getId();
						} else {
						newHashCode = String.valueOf(super.hashCode());

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
	return this.hashCode.hashCode();
	}
	

	
}
