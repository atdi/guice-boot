package org.aav.guice.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.aav.guice.service.repository.UserRepository;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Singleton
public class UserService {

    @Inject
    private UserRepository userRepository;
}
