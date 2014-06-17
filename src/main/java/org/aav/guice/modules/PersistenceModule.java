package org.aav.guice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.aav.guice.model.User;
import org.aav.guice.service.repository.GenericDAO;
import org.aav.guice.service.repository.JpaUserDAO;

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
    }
}
