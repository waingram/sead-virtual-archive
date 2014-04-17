package org.seadva.registry.database.model.dao.vaRegistry.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.seadva.registry.database.model.obj.vaRegistry.DataIdentifierPK;
import org.springframework.stereotype.Repository;
import org.seadva.registry.database.model.dao.vaRegistry.DataIdentifierPKDao;
import java.io.Serializable;
 
/**
 * DAO for table: DataIdentifierPK.
 * @author autogenerated
 */
@Repository
public class DataIdentifierPKDaoImpl extends GenericHibernateDaoImpl<DataIdentifierPK, Serializable> implements DataIdentifierPKDao {
	
	/** Constructor method. */
		public DataIdentifierPKDaoImpl() {
			super(DataIdentifierPK.class);
		}
	}

