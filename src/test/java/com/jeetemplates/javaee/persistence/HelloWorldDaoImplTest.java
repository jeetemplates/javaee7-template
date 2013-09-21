/**
 * 
 */
package com.jeetemplates.javaee.persistence;

import java.io.FileInputStream;
import java.util.List;

import javax.persistence.EntityManager;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.jeetemplates.javaee.common.persistence.BaseDaoTest;
import com.jeetemplates.javaee.domain.HelloWorld;
import com.jeetemplates.javaee.persistence.impl.HelloWorldDaoImpl;

/**
 * Test of {@link HelloWorldDao}.
 * 
 * @author jeetemplates
 */
public class HelloWorldDaoImplTest extends BaseDaoTest {

    /**
     * {@link HelloWorldDao}.
     */
    private HelloWorldDaoImpl helloWorldDaoImpl;
    
    @Override
    protected void initDao(EntityManager entityManager) {
        helloWorldDaoImpl = new HelloWorldDaoImpl();
        helloWorldDaoImpl.setEntityManager(entityManager);
    }

    /**
     * @see org.dbunit.DatabaseTestCase#getDataSet()
     */
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset/dataset.xml"));
    }

    @Test
    public void testRetrieveAll() {
        List<HelloWorld> results = helloWorldDaoImpl.retrieveAll();
        Assert.assertNotNull(results);
        Assert.assertEquals(2, results.size());
    }

}
