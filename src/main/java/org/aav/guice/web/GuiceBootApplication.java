package org.aav.guice.web;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.Set;

/**
 * Created by aurel.avramescu on 12/06/2014.
 */
@Slf4j
@ApplicationPath("/*")
public class GuiceBootApplication extends ResourceConfig {

    /**
     * Create a new resource configuration initialized with a given set of
     * resource/provider classes.
     *
     * @param classes application-specific resource and/or provider classes.
     */
    @Inject
    public GuiceBootApplication(Set<Class<?>> classes) {
        super(classes);
    }

}
