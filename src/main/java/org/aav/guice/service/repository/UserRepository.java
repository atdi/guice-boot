package org.aav.guice.service.repository;

import org.aav.guice.model.User;

import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public interface UserRepository {

    User create(User user);

    User update(User user);

    User findById(UUID id);

    void delete(User user);
}
