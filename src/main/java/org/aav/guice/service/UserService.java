package org.aav.guice.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import org.aav.guice.model.User;
import org.aav.guice.service.repository.UserRepository;

import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Singleton
public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User addUser(User user) {
        return userRepository.create(user);
    }

    @Transactional
    public User updateUser(User user) {
        return userRepository.update(user);
    }

    @Transactional
    public User findById(UUID id) {
        return userRepository.findById(id);
    }


}
