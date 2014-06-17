package org.aav.guice.service.dao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.aav.guice.model.User;
import org.aav.guice.model.UserBuilder;
import org.aav.guice.modules.PersistenceModule;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.persistence.RollbackException;
import java.util.List;
import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class UserRepositoryTest {

    @Inject
    private GenericDAO<User> repository;

    private UUID lastId;

    @BeforeClass
    public void setUp() {
        Injector injector = Guice.createInjector(new PersistenceModule("demo-guice-boot"));
        injector.injectMembers(this);
    }

    @Test
    public void testCreate() {
        lastId = UUID.randomUUID();
        User user = new UserBuilder()
                .withId(lastId)
                .withFirstName("FName")
                .withLastName("LName")
                .withEmail("email@email.com")
                .withPassword("password")
                .build();
        User retUser = repository.create(user);
        assertEquals(user, retUser);
        User user2 = new UserBuilder()
                .withId(UUID.randomUUID())
                .withFirstName("FName")
                .withLastName("LName")
                .withEmail("email2@email.com")
                .withPassword("password")
                .build();
        repository.create(user2);
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

    @Test(dependsOnMethods = {"testGetAllUsers"}, expectedExceptions = {RollbackException.class})
    public void testDuplicateEmail() {
        User user = new UserBuilder()
                .withId(UUID.randomUUID())
                .withFirstName("FName")
                .withLastName("LName")
                .withEmail("email@email.com")
                .withPassword("password")
                .build();
        repository.create(user);
    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testGetAllUsers() {
        List<User> users = repository.findByCriteria(null);
        assertEquals(users.size(), 2);
    }

}
