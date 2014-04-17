package org.seadva.registry.database.model.dao.vaRegistry.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.seadva.registry.database.model.obj.vaRegistry.Agent;
import org.springframework.stereotype.Repository;
import org.seadva.registry.database.model.dao.vaRegistry.AgentDao;
 
 
/**
 * DAO for table: Agent.
 * @author autogenerated
 */
@Repository
public class AgentDaoImpl extends GenericHibernateDaoImpl<Agent, String> implements AgentDao {
	
	/** Constructor method. */
		public AgentDaoImpl() {
			super(Agent.class);
		}
	}

