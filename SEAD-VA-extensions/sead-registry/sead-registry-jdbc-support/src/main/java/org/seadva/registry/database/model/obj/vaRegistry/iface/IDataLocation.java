package org.seadva.registry.database.model.obj.vaRegistry.iface;
import javax.persistence.Basic;
import org.seadva.registry.database.model.obj.vaRegistry.DataLocationPK;


/** 
 * Object interface mapping for hibernate-handled table: data_location.
 * @author autogenerated
 */

public interface IDataLocation {



    /**
     * Return the value associated with the column: id.
	 * @return A DataLocationPK object (this.id)
	 */
	DataLocationPK getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final DataLocationPK id);

    /**
     * Return the value associated with the column: isMasterCopy.
	 * @return A Integer object (this.isMasterCopy)
	 */
	Integer getIsMasterCopy();
	

  
    /**  
     * Set the value related to the column: isMasterCopy.
	 * @param isMasterCopy the isMasterCopy value you wish to set
	 */
	void setIsMasterCopy(final Integer isMasterCopy);

    /**
     * Return the value associated with the column: locationValue.
	 * @return A String object (this.locationValue)
	 */
	String getLocationValue();
	

  
    /**  
     * Set the value related to the column: locationValue.
	 * @param locationValue the locationValue value you wish to set
	 */
	void setLocationValue(final String locationValue);

	// end of interface
}