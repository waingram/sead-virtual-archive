package org.seadva.registry.database.model.dao.vaRegistry.impl;

import org.apache.log4j.Logger;
import org.seadva.registry.database.common.DBConnectionPool;
import org.seadva.registry.database.common.ObjectPool;
import org.seadva.registry.database.model.dao.vaRegistry.BaseEntityDao;
import org.seadva.registry.database.model.dao.vaRegistry.CollectionDao;
import org.seadva.registry.database.model.dao.vaRegistry.StateDao;
import org.seadva.registry.database.model.obj.vaRegistry.BaseEntity;
import org.seadva.registry.database.model.obj.vaRegistry.Collection;
import org.seadva.registry.database.model.obj.vaRegistry.CollectionWrapper;
import org.seadva.registry.database.model.obj.vaRegistry.State;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * DAO for table: Collection.
 * @author autogenerated
 */
@Repository
public class CollectionDaoImpl implements CollectionDao {
    protected Connection getConnection() throws SQLException {
        return connectionPool.getEntry();
    }
    public CollectionDaoImpl(){
        connectionPool = DBConnectionPool.getInstance();
        baseEntityDao = new BaseEntityDaoImpl();
        stateDao = new StateDaoImpl();
    }

    BaseEntityDao baseEntityDao;
    StateDao stateDao;
    private static Logger log = Logger.getLogger(CollectionDaoImpl.class);


    protected ObjectPool<Connection> connectionPool = null;

    @Override
    public Collection getCollection(String entityId) {
        Collection collection = null;
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isCollection = false;


        try {
            connection = getConnection();

            statement = connection.prepareStatement("Select * from collection where entity_id=?");
            statement.setString(1, entityId);
            ResultSet resultSet = statement.executeQuery();

            String name = null;
            int isObsolete = 0;
            State state = null;

            while (resultSet.next()) {
                name = resultSet.getString("name");
                isObsolete = resultSet.getInt("is_obsolete");
                state = stateDao.getStateById(resultSet.getString("state_id"));
                isCollection = true;
                break;
            }

            if(isCollection){
                BaseEntity entity = baseEntityDao.getBaseEntity(entityId);
                collection = new Collection(entity);
                collection.setName(name);
                collection.setIsObsolete(isObsolete);
                collection.setState(state);
            }

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                  //  log.warn("Unable to close statement", e);
                }
                statement = null;
            }
            connectionPool.releaseEntry(connection);

        }
        return collection;
    }

    @Override
    public boolean insertCollection(Collection collection) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            baseEntityDao.insertEntity(collection);
            connection = getConnection();
            statement = connection.prepareStatement("INSERT INTO collection (entity_id, state_id, is_obsolete, version_num, name) values(?,?,?,?,?) " +
                    "ON DUPLICATE KEY UPDATE " +
                    "state_id=?," +
                    "is_obsolete=?," +
                    "version_num=?," +
                    "name=?");
            statement.setString(1, collection.getId());
            statement.setString(2, collection.getState().getId());
            statement.setInt(3, collection.getIsObsolete());
            String versionNum = "1";
            if(collection.getVersionNum()!=null)
                versionNum = collection.getVersionNum();
            statement.setString(4, versionNum);
            statement.setString(5, collection.getName());

            statement.setString(6, collection.getState().getId());
            statement.setInt(7, collection.getIsObsolete());
            statement.setString(8, versionNum);
            statement.setString(9, collection.getName());
            statement.executeUpdate();
            statement.close();

            log.debug("Done resetting unfinished raw notifications");
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.warn("Unable to close statement", e);
                }
                statement = null;
            }
            connectionPool.releaseEntry(connection);

        }

        return true;

    }

    @Override
    public List<Collection> listCollections(String submitterId, String repository, String type){

        List<Collection> collectionsList = new ArrayList<Collection>();

        String queryStr = "Select * from collection C ";

        if(submitterId!=null)
            queryStr+=", Relation R";
        if(repository!=null)
            queryStr+=", DataLocation D, Repository P ";
        if(type!=null)
            queryStr+=", state S";

        queryStr+=" where ";


        if(type!=null)
            queryStr += " C.state_id=S.state_id AND S.state_type='"+type+"' ";


        if(submitterId!=null){
            if(type!=null)
                queryStr+=" AND ";
            queryStr += " R.cause_id=C.id AND R.relation_type_id='rl:3' AND R.effect_id='"+submitterId+"'"; //querying for submitter/publisher.
        }
        // Todo query from RelationType table instead of providing rl:2 as identifier

        if(repository!=null) {
            if(type!=null || submitterId!=null)
                queryStr+=" AND ";
            queryStr += "  C.entity_id = D.entity_id AND D.location_type_id = P.repository_id AND P.repository_name ='"+repository+"'";
        }

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(queryStr);
            ResultSet resultSet = statement.executeQuery();


            List<CollectionWrapper> finalCollectionWrappers = new ArrayList<CollectionWrapper>();

            while (resultSet.next()) {
                String entityId = resultSet.getString("entity_id");
                BaseEntity entity = new BaseEntityDaoImpl().getBaseEntity(entityId);
                Collection collection = new Collection(entity);
                collection.setName(resultSet.getString("name"));
                collection.setIsObsolete(resultSet.getInt("is_obsolete"));

                collectionsList.add(collection);
            }


        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //  log.warn("Unable to close statement", e);
                }
                statement = null;
            }
            connectionPool.releaseEntry(connection);

        }
        return collectionsList;
    }

    @Override
    public List<Collection> queryByProperty(String key, String value){

        List<Collection> collectionsList = new ArrayList<Collection>();

        String queryStr = "Select * from collection C, property P, metadata_type M ";

        queryStr+=" where C.entity_id=P.entity_id, P.metadata_id=M.metadata_id AND M.metadata_element='"+key+"' AND P.valueStr='"+value+"'";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(queryStr);
            ResultSet resultSet = statement.executeQuery();


            List<CollectionWrapper> finalCollectionWrappers = new ArrayList<CollectionWrapper>();

            while (resultSet.next()) {
                String entityId = resultSet.getString("entity_id");
                BaseEntity entity = new BaseEntityDaoImpl().getBaseEntity(entityId);
                Collection collection = new Collection(entity);
                collection.setName(resultSet.getString("name"));
                collection.setIsObsolete(resultSet.getInt("is_obsolete"));

                collectionsList.add(collection);
            }


        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //  log.warn("Unable to close statement", e);
                }
                statement = null;
            }
            connectionPool.releaseEntry(connection);

        }
        return collectionsList;
    }
}

