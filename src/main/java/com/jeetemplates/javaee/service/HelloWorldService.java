/**
 * 
 */
package com.jeetemplates.javaee.service;

import java.util.List;

import com.jeetemplates.javaee.domain.HelloWorld;
import com.jeetemplates.javaee.service.dto.HelloWorldDTO;

/**
 * Hello world service
 * 
 * @author jeetemplates
 */
public interface HelloWorldService {

    /**
     * Create an entity hello world
     * 
     * @param entity
     *            : entity to create
     */
    void create(HelloWorld entity);

    /**
     * Retrieve hello world.
     * 
     * @return
     */
    List<HelloWorldDTO> retrieveAll();

}
