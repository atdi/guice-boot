package org.aav.guice.web;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

/**
 * Created by aurel.avramescu on 12/06/2014.
 */
@Slf4j
@ApplicationPath("/*")
public class GuiceBootApplication extends ResourceConfig {

    @Inject
    public GuiceBootApplication() {
        packages("org.aav.guice.resources");
    }

}
