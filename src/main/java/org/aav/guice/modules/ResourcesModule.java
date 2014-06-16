package org.aav.guice.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.aav.guice.resources.UserResource;

/**
 * Created by aurel.avramescu on 14/06/2014.
 */
public class ResourcesModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(UserResource.class);
    }
}
