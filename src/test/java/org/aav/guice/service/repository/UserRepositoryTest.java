package org.aav.guice.service.repository;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.aav.guice.model.User;
import org.aav.guice.model.UserBuilder;
import org.aav.guice.modules.PersistenceModule;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class UserRepositoryTest {

    @Inject
    private UserRepository repository;

    private UUID lastId;

    @BeforeClass
    public void setUp() {
        Injector injector = Guice.createInjector(new PersistenceModule());
        injector.injectMembers(this);
    }

    @Test
    public void testCreate() {
        lastId = UUID.randomUUID();
        User user = new UserBuilder()
                .withId(lastId)
                .withFirstName("FName")
                .withLastName("LName").build();
        User retUser = repository.create(user);
        assertEquals(user, retUser);
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testFind() {
        User user = repository.findById(lastId);
        assertNotNull(user);
        user.setFirstName("UPdateFirst");
        repository.update(user);
    }

    @Test(dependsOnMethods = {"testFind"})
    public void testUpdate() {
        User user = repository.findById(lastId);
        assertEquals("UPdateFirst", user.getFirstName());
    }


}
