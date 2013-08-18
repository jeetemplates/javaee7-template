/**
 * 
 */
package com.jeetemplates.javaee.persistence;

import java.io.FileInputStream;
import java.util.List;

import javax.inject.Inject;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.jeetemplates.javaee.common.persistence.BaseDaoTest;
import com.jeetemplates.javaee.domain.model.HelloWorld;

/**
 * Test of {@link HelloWorldDao}.
 * 
 * @author jeetemplates
 */
public class HelloWorldDaoTest extends BaseDaoTest {

    /**
     * {@link HelloWorldDao}.
     */
    @Inject
    private HelloWorldDao helloWorldDao;

    /**
     * @see org.dbunit.DatabaseTestCase#getDataSet()
     */
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset/dataset.xml"));
    }

    @Test
    public void testRetrieveAll() {
        List<HelloWorld> results = helloWorldDao.retrieveAll();
        Assert.assertNotNull(results);
        Assert.assertEquals(2, results.size());
    }

}
