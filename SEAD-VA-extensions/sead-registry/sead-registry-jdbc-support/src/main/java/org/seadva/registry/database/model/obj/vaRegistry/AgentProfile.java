package org.seadva.registry.database.model.obj.vaRegistry;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.seadva.registry.database.model.obj.vaRegistry.iface.IAgentProfile;


/** 
 * Object mapping for hibernate-handled table: agent_profile.
 * @author autogenerated
 */

@Entity
@Table(name = "agent_profile", catalog = "va_registry")
public class AgentProfile implements Cloneable, Serializable, IPojoGenEntity, IAgentProfile {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559002659L;

	

	/** Field mapping. */
	@Id 
	private AgentProfilePK id;

	/** Field mapping. */
	@Column( name = "profile_value", nullable = false, length = 256  )
	private String profileValue;

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public AgentProfile() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public AgentProfile(AgentProfilePK id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param id AgentProfilePK object;
	 * @param profileValue String object;
	 */
	public AgentProfile(AgentProfilePK id, String profileValue) {

		this.id = id;
		this.profileValue = profileValue;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return AgentProfile.class;
	}
 

    /**
     * Return the value associated with the column: id.
	 * @return A AgentProfilePK object (this.id)
	 */
	public AgentProfilePK getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final AgentProfilePK id) {
		this.id = id;
	}

    /**
     * Return the value associated with the column: profileValue.
	 * @return A String object (this.profileValue)
	 */
	@Basic( optional = false )
	@Column( name = "profile_value", nullable = false, length = 256  )
	public String getProfileValue() {
		return this.profileValue;
		
	}
	

  
    /**  
     * Set the value related to the column: profileValue.
	 * @param profileValue the profileValue value you wish to set
	 */
	public void setProfileValue(final String profileValue) {
		this.profileValue = profileValue;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public AgentProfile clone() throws CloneNotSupportedException {
		
        final AgentProfile copy = (AgentProfile)super.clone();

		copy.setId(this.getId());
		copy.setProfileValue(this.getProfileValue());
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
		sb.append("profileValue: " + this.getProfileValue());
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see Object#equals(Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		if ( this == aThat ) {
			 return true;
		}

		if ((aThat == null) || ( !(aThat.getClass().equals(this.getClass())))) {
			 return false;
		}
	
		final AgentProfile that = (AgentProfile) aThat;
		return this.getId().equals(that.getId());
	}
	
	/** Calculate the hashcode.
	 * @see Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		return getId().hashCode();
	}
	

	
}