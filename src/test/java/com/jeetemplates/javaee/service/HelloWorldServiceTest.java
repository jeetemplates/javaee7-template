/**
 * 
 */
package com.jeetemplates.javaee.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.jeetemplates.javaee.common.service.BaseServiceTest;
import com.jeetemplates.javaee.domain.HelloWorld;
import com.jeetemplates.javaee.persistence.HelloWorldDao;
import com.jeetemplates.javaee.service.dto.HelloWorldDTO;
import com.jeetemplates.javaee.service.impl.HelloWorldServiceImpl;

/**
 * Test of {@link HelloWorldServiceImpl}.
 * 
 * @author jeetemplates
 */
public class HelloWorldServiceTest extends BaseServiceTest {

	/* ************************************************************** */
	/* Service to test */
	/* ************************************************************** */

	/**
	 * {@link HelloWorldService}.
	 */
	private HelloWorldServiceImpl helloWorldService;

	/**
	 * Init.
	 */
	@Before
	public void init() {
		helloWorldService = new HelloWorldServiceImpl();
		helloWorldService.setHelloWorldDao(mockHelloWorldDao);
	}

	/* ************************************************************** */
	/* Mocks */
	/* ************************************************************** */

	/**
	 * {@link HelloWorldDao}.
	 */
	@Mock
    private HelloWorldDao mockHelloWorldDao;

	/* ************************************************************** */
	/* Methods */
	/* ************************************************************** */

	/**
	 * Test of method {@link HelloWorldService#retrieveAll()}.
	 */
	@Test
	public void testRetrieveAll() {
		// Mock result
		List<HelloWorld> mockResult = new ArrayList<HelloWorld>();
		HelloWorld mockHello = new HelloWorld();
		mockHello.setFirstName("first name");
		mockHello.setLastName("last name");
		mockResult.add(mockHello);

		// Mock call method
		Mockito.when(mockHelloWorldDao.retrieveAll()).thenReturn(mockResult);

		// Call service
		List<HelloWorldDTO> result = helloWorldService.retrieveAll();

		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("first name", result.get(0).getFirstName());
		Assert.assertEquals("last name", result.get(0).getLastName());
	}

}
