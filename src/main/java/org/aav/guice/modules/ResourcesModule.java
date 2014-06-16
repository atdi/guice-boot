package org.aav.guice.modules;

import com.google.inject.AbstractModule;
import org.aav.guice.resources.UserResource;

/**
 * Created by aurel.avramescu on 14/06/2014.
 */
public class ResourcesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserResource.class);
    }
}
