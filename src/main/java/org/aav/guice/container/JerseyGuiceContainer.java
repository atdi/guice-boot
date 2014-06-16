package org.aav.guice.container;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import org.aav.guice.web.GuiceBootApplication;
import org.glassfish.jersey.servlet.ServletContainer;


/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Singleton
public class JerseyGuiceContainer extends ServletContainer {

    private final Injector injector;

    @Inject
    public JerseyGuiceContainer(GuiceBootApplication resourceConfig, Injector injector) {
        super(resourceConfig);
        this.injector = injector;
    }

}
