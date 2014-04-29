package org.seadva.registry.database.model.dao.vaRegistry.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.seadva.registry.database.model.obj.vaRegistry.EntityType;
import org.springframework.stereotype.Repository;
import org.seadva.registry.database.model.dao.vaRegistry.EntityTypeDao;
import org.seadva.registry.database.model.obj.vaRegistry.EntityTypePK;
 
/**
 * DAO for table: EntityType.
 * @author autogenerated
 */
@Repository
public class EntityTypeDaoImpl extends GenericHibernateDaoImpl<EntityType, EntityTypePK> implements EntityTypeDao {
	
	/** Constructor method. */
		public EntityTypeDaoImpl() {
			super(EntityType.class);
		}
	}
