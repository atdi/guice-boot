package org.aav.guice.modules;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;

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
