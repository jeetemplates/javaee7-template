/**
 * 
 */
package com.jeetemplates.javaee.common.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Base class for dao test.
 * 
 * @author jeetemplates
 */
public abstract class BaseDaoTest {

    /**
     * {@link EntityManagerFactory} : entity manager factory.
     */
    private static EntityManagerFactory entityManagerFactory;

    /**
     * {@link EntityManager}.
     */
    private static EntityManager entityManager;

    /**
     * {@link Connection} : connection.
     */
    private static Connection connection;

    /**
     * {@link IDatabaseConnection} : DBUnit connection.
     */
    private static IDatabaseConnection dbunitConnection;

    /**
     * Init context.
     * 
     * @throws DatabaseUnitException
     */
    @BeforeClass
    public static void initClass() throws DatabaseUnitException {
        entityManagerFactory = Persistence.createEntityManagerFactory("puTest");
        entityManager = entityManagerFactory.createEntityManager();
        connection = ((EntityManagerImpl) (entityManager.getDelegate())).getServerSession().getAccessor().getConnection();
        dbunitConnection = new DatabaseConnection(connection, "JUNIT");
        DatabaseConfig dbCfg = dbunitConnection.getConfig();
        dbCfg.setProperty(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES, Boolean.TRUE);
    }

    /**
     * Init test data.
     * 
     * @throws Exception
     * @throws SQLException
     * @throws DatabaseUnitException
     * 
     */
    @Before
    public void init() throws DatabaseUnitException, SQLException, Exception {
        DatabaseOperation.CLEAN_INSERT.execute(dbunitConnection, getDataSet());
    }

    /**
     * Close context.
     * 
     * @throws SQLException
     */
    @AfterClass
    public static void cleanClass() throws SQLException {
        dbunitConnection.close();
        connection.close();
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     * Get dataset.
     * 
     * @return data set
     * @throws Exception
     */
    protected abstract IDataSet getDataSet() throws Exception;

}
