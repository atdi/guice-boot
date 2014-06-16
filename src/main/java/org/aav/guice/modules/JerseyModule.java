package org.aav.guice.modules;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import org.aav.guice.container.JerseyGuiceContainer;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.internal.ServiceLocatorFactoryImpl;

/**
 * Created by aurel.avramescu on 14/06/2014.
 */
public class JerseyModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/*").with(JerseyGuiceContainer.class);
    }

    @Provides
    public ServiceLocator serviceLocator() {
        return ServiceLocatorFactoryImpl.getInstance().create("guice-bridge");
    }

}
