package org.aav.guice.modules;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import org.aav.guice.container.JerseyGuiceContainer;
import org.aav.guice.resources.UserResource;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aurel.avramescu on 14/06/2014.
 */
public class JerseyModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/*").with(JerseyGuiceContainer.class);
    }

    @Provides
    public static Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        //getClasses("com.aav.guice.resources");
        classes.add(UserResource.class);
        return classes;
    }

}
