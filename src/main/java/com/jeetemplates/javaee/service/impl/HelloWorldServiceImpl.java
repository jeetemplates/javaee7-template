/**
 * 
 */
package com.jeetemplates.javaee.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jeetemplates.javaee.domain.HelloWorld;
import com.jeetemplates.javaee.logging.Loggable;
import com.jeetemplates.javaee.persistence.HelloWorldDao;
import com.jeetemplates.javaee.rest.api.HelloWorldServiceRest;
import com.jeetemplates.javaee.service.HelloWorldService;

/**
 * Implementation of {@link HelloWorldService}
 * 
 * @author jeetemplates
 */
@Stateless
@Loggable
public class HelloWorldServiceImpl implements HelloWorldService, HelloWorldServiceRest {

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /**
     * {@link HelloWorldDao}
     */
    @Inject
    private HelloWorldDao helloWorldDao;

    /* ************************************ */
    /* Methods */
    /* ************************************ */

    @Override
    public void create(HelloWorld entity) {
        helloWorldDao.create(entity);
    }

    @Override
    public List<HelloWorld> retrieveAll() {
        List<HelloWorld> listEntities = helloWorldDao.retrieveAll();
        return listEntities;
    }

    /* ************************************ */
    /* Getters & Setters */
    /* ************************************ */

    /**
     * @param helloWorldDao
     *            the helloWorldDao to set
     */
    public void setHelloWorldDao(HelloWorldDao helloWorldDao) {
        this.helloWorldDao = helloWorldDao;
    }

}
