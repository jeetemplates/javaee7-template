/**
 * 
 */
package com.jeetemplates.javaee.common.persistence.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jeetemplates.javaee.common.domain.BusinessEntity;
import com.jeetemplates.javaee.common.persistence.BusinessDao;

/**
 * Generic DAO implementation.
 * 
 * @author jeetemplates
 */
public abstract class BusinessDaoImpl<ID, BE extends BusinessEntity<ID>> implements BusinessDao<ID, BE> {

    /* ************************************************************** */
    /* Technical */
    /* ************************************************************** */

    /**
     * Class of BusinessEntity
     */
    @SuppressWarnings("unchecked")
    private Class<BE> persistentClass = (Class<BE>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];

    /* ************************************************************** */
    /* Dependencies */
    /* ************************************************************** */

    // @Produces is used to @Inject EntityManager
    @Produces
    @PersistenceContext(unitName = "javaee7-template")
    protected EntityManager entityManager;

    /* ************************************************************** */
    /* Methods */
    /* ************************************************************** */

    @Override
    public BE create(final BE entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public BE retrieveById(final ID id) {
        return entityManager.find(persistentClass, id);
    }

    @Override
    public List<BE> retrieveAll() {
        return entityManager.createQuery("from " + persistentClass.getName() + " entity", persistentClass).getResultList();
    }

    @Override
    public BE update(final BE entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(final BE entity) {
        entityManager.remove(entity);

    }

    @Override
    public void deleteById(final ID id) {
        entityManager.remove(retrieveById(id));
    }

    /* ************************************************************** */
    /* Getters & Setters */
    /* ************************************************************** */

    /**
     * @param entityManager
     *            the entityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
