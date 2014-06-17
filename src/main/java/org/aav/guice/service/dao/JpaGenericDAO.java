package org.aav.guice.service.dao;

import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.UUID;

/**
 * Created by aurel.avramescu on 17/06/2014.
 */
public abstract class JpaGenericDAO<E> implements GenericDAO<E> {

    @Inject
    protected EntityManager entityManager;

    private final Class<E> clazz;

    public JpaGenericDAO(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Transactional
    @Override
    public E create(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public E update(E entity) {
        return entity;
    }

    @Transactional
    @Override
    public E findById(UUID id) {
        return entityManager.find(clazz, id);
    }

    @Transactional
    @Override
    public void delete(E entity) {
        entityManager.remove(entity);
    }
}
