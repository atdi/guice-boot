package org.aav.guice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.aav.guice.model.Role;
import org.aav.guice.model.User;
import org.aav.guice.service.dao.GenericDAO;
import org.aav.guice.service.dao.JpaRoleDAO;
import org.aav.guice.service.dao.JpaUserDAO;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class PersistenceModule extends AbstractModule {

    private final String persistenceUnit;

    public PersistenceModule(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    @Override
    protected void configure() {
        install(new JpaPersistModule(persistenceUnit));
        bind(JpaInitializer.class).asEagerSingleton();
        bind(new TypeLiteral<GenericDAO<User>>() {
        }).to(new TypeLiteral<JpaUserDAO>() {
        });
        bind(new TypeLiteral<GenericDAO<Role>>() {
        }).to(new TypeLiteral<JpaRoleDAO>() {
        });
    }
}
