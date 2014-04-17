package org.seadva.registry.database.model.dao.vaRegistry.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.seadva.registry.database.model.obj.vaRegistry.DataLocation;
import org.springframework.stereotype.Repository;
import org.seadva.registry.database.model.dao.vaRegistry.DataLocationDao;
import org.seadva.registry.database.model.obj.vaRegistry.DataLocationPK;
 
/**
 * DAO for table: DataLocation.
 * @author autogenerated
 */
@Repository
public class DataLocationDaoImpl extends GenericHibernateDaoImpl<DataLocation, DataLocationPK> implements DataLocationDao {
	
	/** Constructor method. */
		public DataLocationDaoImpl() {
			super(DataLocation.class);
		}
	}

