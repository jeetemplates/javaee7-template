/**
 * 
 */
package com.jeetemplates.javaee.web.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.inject.Inject;
import javax.inject.Named;

import com.jeetemplates.javaee.configuration.InjectedConfiguration;
import com.jeetemplates.javaee.domain.HelloWorld;
import com.jeetemplates.javaee.logging.LoggingProducer;
import com.jeetemplates.javaee.service.HelloWorldService;
import com.jeetemplates.javaee.web.exception.CatchException;

/**
 * Welcome controller.
 * 
 * @author jeetemplates
 */
// Annotation @Named mandatory for JSF beans to be processed by EL.
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

    /**
     * Message from configuration file.
     */
    @Inject
    @InjectedConfiguration(key = "message", mandatory = true)
    private String configurationMessage;

    /* ************************************ */
    /* Attributes */
    /* ************************************ */

    /**
     * New hello.
     */
    private HelloWorld newHello;

    /**
     * Ajax hello.
     */
    private HelloWorld ajaxHello;

    /**
     * List of hellos
     */
    private List<HelloWorld> hellos;

    /* ************************************ */
    /* Methods */
    /* ************************************ */

    /**
     * Init method.
     */
    @PostConstruct
    public void init() {
        newHello = new HelloWorld();
        ajaxHello = new HelloWorld();
        logger.info("Initialize hello world list for display");
        hellos = helloWorldService.retrieveAll();
    }

    /**
     * Create hello.
     * 
     * @return
     */
    public String createHello() {
        if (newHello.getEmail() != null && newHello.getEmail().isEmpty()) {
            newHello.setEmail(null);
        }
        helloWorldService.create(newHello);
        return "welcome?faces-redirect=true";
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

    /* ************************************ */
    /* Getters & Setters */
    /* ************************************ */

    /**
     * Throw {@link FacesException}.
     * 
     * @return outcome "welcome"
     */
    public String throwException() {
        throw new NullPointerException(
                "Null pointer exception thrown for example");
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

    /**
     * @return the logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * @param logger
     *            the logger to set
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * @return the configurationMessage
     */
    public String getConfigurationMessage() {
        return configurationMessage;
    }

    /**
     * @param configurationMessage
     *            the configurationMessage to set
     */
    public void setConfigurationMessage(String configurationMessage) {
        this.configurationMessage = configurationMessage;
    }

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
     * @param ajaxHello
     *            the ajaxHello to set
     */
    public void setAjaxHello(HelloWorld ajaxHello) {
        this.ajaxHello = ajaxHello;
    }

    /**
     * @return the hellos
     */
    public List<HelloWorld> getHellos() {
        return hellos;
    }

    /**
     * @param hellos
     *            the hellos to set
     */
    public void setHellos(List<HelloWorld> hellos) {
        this.hellos = hellos;
    }

}
