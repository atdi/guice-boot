package org.aav.guice.modules;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Singleton
public class JpaInitializer {

    @Inject
    public JpaInitializer(final PersistService service)
    {
        service.start();
    }
}
