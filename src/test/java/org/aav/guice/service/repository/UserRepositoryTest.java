package org.aav.guice.service.repository;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.aav.guice.model.User;
import org.aav.guice.model.UserBuilder;
import org.aav.guice.modules.PersistenceModule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class UserRepositoryTest {

    @Inject
    private JpaUserRepository repository;

    @BeforeClass
    public void setUp() {
        Injector injector = Guice.createInjector(new PersistenceModule());
        injector.injectMembers(this);
    }

    @Test
    public void testCreate() {
        User user = new UserBuilder()
                .withId(UUID.randomUUID())
                .withFirstName("FName")
                .withLastName("LName").build();
        repository.create(user);
    }


}
