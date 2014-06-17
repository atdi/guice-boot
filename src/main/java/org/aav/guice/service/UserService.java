package org.aav.guice.service;

import com.google.inject.persist.Transactional;
import org.aav.guice.model.User;
import org.aav.guice.service.repository.GenericDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Singleton
public class UserService {

    private final GenericDAO<User> userDAO;

    @Inject
    public UserService(GenericDAO<User> userRepository) {
        this.userDAO = userRepository;
    }

    @Transactional
    public User addUser(User user) {
        return userDAO.create(user);
    }

    @Transactional
    public User updateUser(User user) {
        return userDAO.update(user);
    }

    @Transactional
    public User findById(UUID id) {
        return userDAO.findById(id);
    }

    @Transactional
    public List<User> findUsers() {
        return userDAO.findByCriteria(null);
    }

}
