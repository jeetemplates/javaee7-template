/**
 * 
 */
package com.jeetemplates.javaee.common.domain;

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
public abstract class BusinessEntity<ID> implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id.
	 */
	private ID id;

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue
	public ID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ID id) {
		this.id = id;
	}

}
