/**
 * 
 */
package com.jeetemplates.javaee.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Business Entity
 * 
 * @author jeetemplates
 */
@MappedSuperclass
public abstract class BusinessEntity implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id.
	 */
	private Long id;

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
