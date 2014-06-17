package org.aav.guice.service.repository;

import java.util.UUID;

/**
 * Created by aurel.avramescu on 17/06/2014.
 */
public interface GenericDAO<E> {

    E create(E entity);

    E update(E entity);

    E findById(UUID id);

    void delete(E entity);
}
