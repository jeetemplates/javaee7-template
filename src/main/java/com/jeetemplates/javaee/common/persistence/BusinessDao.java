/**
 * 
 */
package com.jeetemplates.javaee.common.persistence;

import java.util.List;

import com.jeetemplates.javaee.common.domain.BusinessEntity;

/**
 * Generic DAO Interface. CRUD methods.
 * 
 * @author jeetemplates
 */
public interface BusinessDao<ID, BE extends BusinessEntity<ID>> {

	/**
	 * Create in database
	 * 
	 * @param entity
	 * @return entity persisted
	 */
	BE create(BE entity);

	/**
	 * Retrieve from database by id
	 * 
	 * @param id
	 * @return
	 */
	BE retrieveById(ID id);

	/**
	 * Retrieve all entries from database
	 * 
	 * @return
	 */
	List<BE> retrieveAll();

	/**
	 * Update entity in database
	 * 
	 * @param entity
	 *            : entity to update
	 * @return persisted entity
	 */
	BE update(BE entity);

	/**
	 * Delete from database by persistent entity
	 * 
	 * @param entity
	 *            : entity to delete
	 */
	void delete(BE entity);

	/**
	 * Delete from database by id
	 * 
	 * @param id
	 *            : entity's id to delete
	 */
	void deleteById(ID id);

}
