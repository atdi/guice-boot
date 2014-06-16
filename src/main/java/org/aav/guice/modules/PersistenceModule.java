package org.aav.guice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.aav.guice.service.repository.JpaUserRepository;
import org.aav.guice.service.repository.UserRepository;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("demo-guice-test"));
        bind(JpaInitializer.class).asEagerSingleton();
        bind(UserRepository.class).to(JpaUserRepository.class);
    }
}
