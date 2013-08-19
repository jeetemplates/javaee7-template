/**
 * 
 */
package com.jeetemplates.javaee.rest.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jeetemplates.javaee.service.dto.HelloWorldDTO;

/**
 * Hello world rest api.
 * 
 * @author jeetemplates
 */
@Path("/hello")
public interface HelloWorldServiceRest {

    /**
     * Retrieve hello world.
     * 
     * @return
     */
    @Path("/retrieveAll")
    @GET
    @Produces(value = { MediaType.APPLICATION_JSON })
    List<HelloWorldDTO> retrieveAll();

}
