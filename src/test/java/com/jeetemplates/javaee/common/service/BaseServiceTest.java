/**
 * 
 */
package com.jeetemplates.javaee.common.service;

import ma.glasnost.orika.MapperFacade;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.jeetemplates.javaee.mapper.OrikaMapper;

/**
 * Base class for service test.
 * 
 * @author jeetemplates
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class BaseServiceTest {

	/**
	 * {@link MapperFacade}.
	 */
	protected MapperFacade mapper = new OrikaMapper();

}
