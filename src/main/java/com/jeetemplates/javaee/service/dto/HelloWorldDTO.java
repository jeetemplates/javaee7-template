/**
 * 
 */
package com.jeetemplates.javaee.service.dto;

import java.io.Serializable;

/**
 * Hello world dto
 * 
 * @author jeetemplates
 */
public class HelloWorldDTO implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = -4404486271848958120L;

	/**
	 * Default constructor.
	 */
	public HelloWorldDTO() {

	}

	/**
	 * Constructor with params.
	 * 
	 * @param lastName
	 * @param firstName
	 */
	public HelloWorldDTO(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

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
