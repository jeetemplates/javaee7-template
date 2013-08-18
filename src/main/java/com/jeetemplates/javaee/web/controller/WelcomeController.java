/**
 * 
 */
package com.jeetemplates.javaee.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.inject.Inject;
import javax.inject.Named;

import com.jeetemplates.javaee.service.HelloWorldService;
import com.jeetemplates.javaee.service.dto.HelloWorldDTO;
import com.jeetemplates.javaee.web.form.HelloWorldForm;

/**
 * Welcome controller.
 * 
 * @author jeetemplates
 */
@Named
@RequestScoped
public class WelcomeController implements Serializable {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = -5812423521893870934L;

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /**
     * {@link HelloWorldService}
     */
    @Inject
    private HelloWorldForm helloWorldForm;

    /**
     * {@link HelloWorldService}.
     */
    @Inject
    private HelloWorldService helloWorldService;

    /* ************************************ */
    /* Attributes */
    /* ************************************ */

    /* ************************************ */
    /* Methods */
    /* ************************************ */

    /**
     * Create hello.
     * 
     * @return welcome view
     */
    public String createHello() {
        HelloWorldDTO dto = new HelloWorldDTO();
        dto.setFirstName(helloWorldForm.getFirstName());
        dto.setLastName(helloWorldForm.getLastName());
        helloWorldService.create(dto);
        return "welcome?faces-redirect=true";
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
     * Retrieve hello dto
     * 
     * @return list of hello dto
     */
    public List<HelloWorldDTO> retrieveList() {
        return helloWorldService.retrieveAll();
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

}
