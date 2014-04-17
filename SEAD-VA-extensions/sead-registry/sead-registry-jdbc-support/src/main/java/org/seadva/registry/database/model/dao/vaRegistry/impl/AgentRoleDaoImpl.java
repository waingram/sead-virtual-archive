package org.seadva.registry.database.model.dao.vaRegistry.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.seadva.registry.database.model.obj.vaRegistry.AgentRole;
import org.springframework.stereotype.Repository;
import org.seadva.registry.database.model.dao.vaRegistry.AgentRoleDao;
import org.seadva.registry.database.model.obj.vaRegistry.AgentRolePK;
 
/**
 * DAO for table: AgentRole.
 * @author autogenerated
 */
@Repository
public class AgentRoleDaoImpl extends GenericHibernateDaoImpl<AgentRole, AgentRolePK> implements AgentRoleDao {
	
	/** Constructor method. */
		public AgentRoleDaoImpl() {
			super(AgentRole.class);
		}
	}

