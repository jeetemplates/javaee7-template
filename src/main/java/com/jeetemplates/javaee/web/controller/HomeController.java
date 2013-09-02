/**
 * 
 */
package com.jeetemplates.javaee.web.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.inject.Inject;
import javax.inject.Named;

import com.jeetemplates.javaee.domain.HelloWorld;
import com.jeetemplates.javaee.logging.LoggingProducer;
import com.jeetemplates.javaee.service.HelloWorldService;
import com.jeetemplates.javaee.web.exception.CatchException;

/**
 * Welcome controller.
 * 
 * @author jeetemplates
 */
@Named
@RequestScoped
@CatchException
public class HomeController {

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /**
     * {@link HelloWorldService}
     */
    @Inject
    private HelloWorldService helloWorldService;

    /**
     * {@link LoggingProducer}.
     */
    @Inject
    private Logger logger;

    /* ************************************ */
    /* Attributes */
    /* ************************************ */

    /**
     * New hello.
     */
    private HelloWorld newHello = new HelloWorld();
    
    /**
     * Ajax hello.
     */
    private HelloWorld ajaxHello = new HelloWorld();

    /**
     * List of hellos
     */
    private List<HelloWorld> listHellos;

    /* ************************************ */
    /* Methods */
    /* ************************************ */

    public String createHello() {
        if (newHello.getEmail() != null && newHello.getEmail().isEmpty()) {
            newHello.setEmail(null);
        }
        helloWorldService.create(newHello);
        return "welcome?faces-redirect=true";
    }

    /**
     * Retrieve hello dto
     * 
     * @return list of hello dto
     */
    public List<HelloWorld> retrieveList() {
        // Prevent multiple calls from JSF
        if (listHellos == null) {
            logger.info("Initialize hello world list for display");
            listHellos = helloWorldService.retrieveAll();
        }
        return listHellos;
    }

    /**
     * Display ajax message.
     * 
     * @return ajax message
     */
    public String displayHelloAjax() {
        StringBuilder response = new StringBuilder();
        String firstName = ajaxHello.getFirstName();
        if (firstName != null && firstName.length() > 0) {
            response.append(firstName);
        }
        String lastName = ajaxHello.getLastName();
        if (lastName != null && lastName.length() > 0) {
            response.append(" ");
            response.append(lastName);
        }
        if (response.length() > 0) {
            response.insert(0, "Hello ");
            response.append(" !");
        }
        return response.toString();
    }

    /**
     * Throw {@link FacesException}.
     * 
     * @return outcome "welcome"
     */
    public String throwException() {
        throw new NullPointerException("Null pointer exception thrown for example");
    }

    /* ************************************ */
    /* Getters & Setters */
    /* ************************************ */

    /**
     * @return the newHello
     */
    public HelloWorld getNewHello() {
        return newHello;
    }

    /**
     * @param newHello
     *            the newHello to set
     */
    public void setNewHello(HelloWorld newHello) {
        this.newHello = newHello;
    }

    /**
     * @return the ajaxHello
     */
    public HelloWorld getAjaxHello() {
        return ajaxHello;
    }

    /**
     * @param ajaxHello the ajaxHello to set
     */
    public void setAjaxHello(HelloWorld ajaxHello) {
        this.ajaxHello = ajaxHello;
    }

    /**
     * @return the helloWorldService
     */
    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }

    /**
     * @param helloWorldService
     *            the helloWorldService to set
     */
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

}
