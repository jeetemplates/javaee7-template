/**
 * 
 */
package com.jeetemplates.javaee.web.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.inject.Inject;
import javax.inject.Named;

import com.jeetemplates.javaee.domain.model.HelloWorld;
import com.jeetemplates.javaee.service.HelloWorldService;
import com.jeetemplates.javaee.service.dto.HelloWorldDTO;
import com.jeetemplates.javaee.util.LoggerUtils;
import com.jeetemplates.javaee.util.MapperUtils;
import com.jeetemplates.javaee.web.form.HelloWorldForm;

/**
 * Welcome controller.
 * 
 * @author jeetemplates
 */
@Named
@RequestScoped
public class WelcomeController {

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /**
     * {@link HelloWorldService}
     */
    @Inject
    private HelloWorldService helloWorldService;

    /**
     * {@link HelloWorldService}
     */
    @Inject
    private HelloWorldForm helloWorldForm;

    /* ************************************ */
    /* Attributes */
    /* ************************************ */

    /**
     * List of hellos
     */
    private List<HelloWorldDTO> listHellos;

    /* ************************************ */
    /* Methods */
    /* ************************************ */

    public String createHello() {
        helloWorldService.create((HelloWorld) MapperUtils.map(helloWorldForm, HelloWorld.class));
        return "welcome?faces-redirect=true";
    }

    /**
     * Retrieve hello dto
     * 
     * @return list of hello dto
     */
    public List<HelloWorldDTO> retrieveList() {
        // Prevent multiple calls from JSF
        if (listHellos == null) {
            LoggerUtils.logDebug("Initialize hello world list for display");
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
        String firstName = helloWorldForm.getFirstName();
        if (firstName != null && firstName.length() > 0) {
            response.append(firstName);
        }
        String lastName = helloWorldForm.getLastName();
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
        throw new FacesException();
    }

    /* ************************************ */
    /* Getters & Setters */
    /* ************************************ */

    public void setHelloWorldForm(HelloWorldForm helloWorldForm) {
        this.helloWorldForm = helloWorldForm;
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

}
