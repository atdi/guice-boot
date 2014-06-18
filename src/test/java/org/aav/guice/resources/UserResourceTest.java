package org.aav.guice.resources;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.aav.guice.model.User;
import org.aav.guice.model.UserBuilder;
import org.aav.guice.modules.PersistenceModule;
import org.aav.guice.modules.ResourcesModule;
import org.aav.guice.service.dao.GenericDAO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by aurel.avramescu on 18/06/2014.
 */
public class UserResourceTest {

    @Inject
    private UserResource resource;

    private Response lastResponse;

    @BeforeClass
    public void setUp() {
        Injector injector = Guice.createInjector(new PersistenceModule("demo-guice-boot"), new ResourcesModule());
        injector.injectMembers(this);
    }

    @Test
    public void testAddUser() {
        User user = new UserBuilder()
                .withFirstName("FName")
                .withLastName("LName")
                .withEmail("email@email.com")
                .withPassword("password")
                .build();
        lastResponse = resource.addUser(user);
        assertEquals(user.getEmail(), ((User) lastResponse.getEntity()).getEmail());
        assertNotNull(((User)lastResponse.getEntity()).getId());
    }
}
