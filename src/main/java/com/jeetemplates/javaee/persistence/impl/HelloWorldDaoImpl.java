/**
 * 
 */
package com.jeetemplates.javaee.persistence.impl;

import javax.inject.Named;

import com.jeetemplates.javaee.common.persistence.impl.BusinessDaoImpl;
import com.jeetemplates.javaee.domain.model.HelloWorld;
import com.jeetemplates.javaee.persistence.HelloWorldDao;

/**
 * Hibernate implementation of {@link HelloWorldDao}
 * 
 * @author jeetemplates
 */
@Named
public class HelloWorldDaoImpl extends BusinessDaoImpl<HelloWorld> implements HelloWorldDao {

}
