/**
 * 
 */
package com.jeetemplates.javaee.web.form;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Hello world form
 * 
 * @author jeetemplates
 */
@Named
@RequestScoped
public class HelloWorldForm implements Serializable {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = -8962025293001375062L;

    /**
     * Last name.
     */
    private String lastName;

    /**
     * First name.
     */
    private String firstName;

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
