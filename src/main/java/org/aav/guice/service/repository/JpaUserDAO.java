package org.aav.guice.service.repository;

import org.aav.guice.model.User;


/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class JpaUserDAO extends JpaGenericDAO<User> {

    public JpaUserDAO() {
        super(User.class);
    }
}
