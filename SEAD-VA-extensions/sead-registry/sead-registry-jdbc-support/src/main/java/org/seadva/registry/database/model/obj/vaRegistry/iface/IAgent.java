package org.seadva.registry.database.model.obj.vaRegistry.iface;
import java.util.Set;
import javax.persistence.Basic;
import org.seadva.registry.database.model.obj.vaRegistry.AgentProfile;
import org.seadva.registry.database.model.obj.vaRegistry.AgentRole;
import org.seadva.registry.database.model.obj.vaRegistry.iface.IBaseEntity;


/** 
 * Object interface mapping for hibernate-handled table: agent.
 * @author autogenerated
 */

public interface IAgent extends IBaseEntity {



    /**
     * Return the value associated with the column: agentProfile.
	 * @return A Set&lt;AgentProfile&gt; object (this.agentProfile)
	 */
	Set<AgentProfile> getAgentProfiles();
	
	/**
	 * Adds a bi-directional link of type AgentProfile to the agentProfiles set.
	 * @param agentProfile item to add
	 */
	void addAgentProfile(AgentProfile agentProfile);

  
    /**  
     * Set the value related to the column: agentProfile.
	 * @param agentProfile the agentProfile value you wish to set
	 */
	void setAgentProfiles(final Set<AgentProfile> agentProfile);

    /**
     * Return the value associated with the column: agentRole.
	 * @return A Set&lt;AgentRole&gt; object (this.agentRole)
	 */
	Set<AgentRole> getAgentRoles();
	
	/**
	 * Adds a bi-directional link of type AgentRole to the agentRoles set.
	 * @param agentRole item to add
	 */
	void addAgentRole(AgentRole agentRole);

  
    /**  
     * Set the value related to the column: agentRole.
	 * @param agentRole the agentRole value you wish to set
	 */
	void setAgentRoles(final Set<AgentRole> agentRole);

    /**
     * Return the value associated with the column: firstName.
	 * @return A String object (this.firstName)
	 */
	String getFirstName();
	

  
    /**  
     * Set the value related to the column: firstName.
	 * @param firstName the firstName value you wish to set
	 */
	void setFirstName(final String firstName);

    /**
     * Return the value associated with the column: lastName.
	 * @return A String object (this.lastName)
	 */
	String getLastName();
	

  
    /**  
     * Set the value related to the column: lastName.
	 * @param lastName the lastName value you wish to set
	 */
	void setLastName(final String lastName);

	// end of interface
}