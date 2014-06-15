package org.aav.guice.service.repository;

import com.google.inject.Inject;
import org.aav.guice.model.User;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class JpaUserRepository implements UserRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        return user;
    }

    @Override
    @Transactional
    public User findById(final UUID id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void delete(final User user) {
        entityManager.remove(user);
    }
}